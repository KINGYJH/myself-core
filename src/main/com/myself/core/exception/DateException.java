package com.myself.core.exception;

/**
 * Created by yjh on 2015/7/28.
 */
public class DateException extends RuntimeException {
    public DateException() {
        super();
    }

    public DateException(String message) {
        super(message);
    }

    public DateException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DateException(Throwable throwable) {
        super(throwable);
    }
}
