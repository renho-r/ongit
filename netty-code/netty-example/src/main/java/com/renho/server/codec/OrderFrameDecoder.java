package com.renho.server.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class OrderFrameDecoder extends LengthFieldBasedFrameDecoder {

    public OrderFrameDecoder() {
        super(Integer.MAX_VALUE, 0, 2, 0, 2);
    }
}
