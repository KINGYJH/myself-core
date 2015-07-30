package com.myself.core.exception;

/**
 * Created by yjh on 2015/7/28.
 */
public class ExistException extends RuntimeException {
    public ExistException() {
        super();
    }

    public ExistException(String message) {
        super(message);
    }

    public ExistException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ExistException(Throwable throwable) {
        super(throwable);
    }
}
