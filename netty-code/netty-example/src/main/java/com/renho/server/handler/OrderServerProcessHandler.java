package com.renho.server.handler;

import com.google.common.util.concurrent.Uninterruptibles;
import com.renho.common.Operation;
import com.renho.common.OperationResult;
import com.renho.common.RequestMessage;
import com.renho.common.ResponseMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class OrderServerProcessHandler extends SimpleChannelInboundHandler<RequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestMessage requestMessage) throws Exception {

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

//        ByteBuf buffer = ctx.alloc().buffer();

        Operation operation = requestMessage.getMessageBody();
        OperationResult operationResult = operation.execute();

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessageHeader(requestMessage.getMessageHeader());
        responseMessage.setMessageBody(operationResult);

        ctx.writeAndFlush(responseMessage);
    }
}
