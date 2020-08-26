package com.renho.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class NettyEchoHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
        ByteBuf byteBuf = Unpooled.buffer(1024);
        byteBuf.writeBytes("renho".getBytes());
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead：" + msg);
        try {
            ByteBuf byteBuf = (ByteBuf) msg;
            String msgStr = byteBuf.toString(CharsetUtil.UTF_8).trim();
            System.out.println("channelRead：" + msgStr);

            String back = "[echo]" + msgStr + "\n";
            byte[] backs = back.getBytes();
            ByteBuf backBuf = Unpooled.buffer(back.length());
            backBuf.writeBytes(backs);
            ctx.writeAndFlush(backBuf);

            if ("bye".equalsIgnoreCase(msgStr)) {
            }
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
