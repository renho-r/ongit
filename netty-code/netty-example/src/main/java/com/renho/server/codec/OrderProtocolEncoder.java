package com.renho.server.codec;

import com.renho.common.ResponseMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class OrderProtocolEncoder extends MessageToMessageEncoder<ResponseMessage> {

    @Override
    protected void encode(ChannelHandlerContext ctx, ResponseMessage responseMessage, List<Object> out) throws Exception {
        ByteBuf byteBuf = ctx.alloc().buffer();
        responseMessage.encode(byteBuf);
        out.add(byteBuf);
    }
}
