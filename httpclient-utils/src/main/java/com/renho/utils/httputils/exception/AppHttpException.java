package com.renho.utils.httputils.exception;

import org.apache.http.HttpException;
import org.apache.http.StatusLine;

public class AppHttpException extends HttpException {

    private StatusLine statusLine;

    public AppHttpException(String message, Throwable e, StatusLine statusLine) {
        super(message, e);
        this.statusLine = statusLine;
    }

}
