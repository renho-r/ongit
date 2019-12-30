package com.renho.client;

import com.renho.client.codec.OrderFrameDecoder;
import com.renho.client.codec.OrderFrameEncoder;
import com.renho.client.codec.OrderProtocolDecoder;
import com.renho.client.codec.OrderProtocolEncoder;
import com.renho.client.codec.handler.ClientIdleCheckHandler;
import com.renho.client.codec.handler.KeepaliveHandler;
import com.renho.common.RequestMessage;
import com.renho.common.auth.AuthOperation;
import com.renho.common.order.OrderOperation;
import com.renho.util.IdUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class ClientV0 {

    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        EventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group);
        KeepaliveHandler keepaliveHandler = new KeepaliveHandler();
        bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10 *  1000);
        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {

                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new ClientIdleCheckHandler());
                pipeline.addLast(new OrderFrameDecoder());
                pipeline.addLast(new OrderFrameEncoder());

                pipeline.addLast(new OrderProtocolEncoder());
                pipeline.addLast(new OrderProtocolDecoder());

                pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                pipeline.addLast(keepaliveHandler);

            }
        });

        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8090);
        channelFuture.sync();

        AuthOperation authOperation = new AuthOperation("admin1", "password");

        channelFuture.channel().writeAndFlush(new RequestMessage(IdUtil.nextId(), authOperation));


        RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), new OrderOperation(1001, "tudou"));
//        for (int i=0; i<20; i++) {
//            channelFuture.channel().writeAndFlush(requestMessage);
//        }
        channelFuture.channel().writeAndFlush(requestMessage);
        channelFuture.channel().closeFuture().sync();
    }

}
