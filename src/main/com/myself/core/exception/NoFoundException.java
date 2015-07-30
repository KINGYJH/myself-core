package com.myself.core.exception;

/**
 * Created by yjh on 2015/7/28.
 */
public class NoFoundException extends RuntimeException {
    public NoFoundException() {
        super();
    }

    public NoFoundException(String message) {
        super(message);
    }

    public NoFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public NoFoundException(Throwable throwable) {
        super(throwable);
    }
}

