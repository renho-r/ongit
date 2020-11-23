package com.renho.test.mybatisplus.common.ext.idgenerator.exception;

public class ClockMovedBackException extends RuntimeException {
    public ClockMovedBackException(String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
    }
}
