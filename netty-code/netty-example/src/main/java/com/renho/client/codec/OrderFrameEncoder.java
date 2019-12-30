package com.renho.client.codec;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class OrderFrameEncoder extends LengthFieldPrepender {

    public OrderFrameEncoder() {
        super(2);
    }
}
