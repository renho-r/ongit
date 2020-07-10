package com.renho.reactor3.create;

import java.util.List;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public interface MyEventListener<T> {
    void onDataChunk(List<T> chunk);
    void processComplete();
}
