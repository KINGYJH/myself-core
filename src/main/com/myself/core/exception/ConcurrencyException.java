package com.myself.core.exception;

/**
 * Created by yjh on 2015/7/28.
 */
public class ConcurrencyException extends RuntimeException {
    public ConcurrencyException() {
        super();
    }

    public ConcurrencyException(String message) {
        super(message);
    }

    public ConcurrencyException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ConcurrencyException(Throwable throwable) {
        super(throwable);
    }
}
