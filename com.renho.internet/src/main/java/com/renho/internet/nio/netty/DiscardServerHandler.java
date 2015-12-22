package com.renho.internet.nio.netty;

import io.netty.buffer.ByteBuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerAdapter;

/**
 * Handles a server-side channel.
 */
public class DiscardServerHandler extends ChannelHandlerAdapter { // (1)

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
		ByteBuf in = (ByteBuf) msg;
		while (in.isReadable()) {
			System.out.print((char) in.readByte());
			System.out.flush();
		}
		ctx.write(msg);
		ctx.flush();

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("DiscardServerHandler");
		super.channelActive(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
		// Close the connection when an exception is raised.
		cause.printStackTrace();
		ctx.close();
	}
}