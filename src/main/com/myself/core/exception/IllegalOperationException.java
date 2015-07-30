package com.myself.core.exception;

/**
 * Created by yjh on 2015/7/28.
 */
public class IllegalOperationException extends RuntimeException {
    public IllegalOperationException() {
        super();
    }

    public IllegalOperationException(String message) {
        super(message);
    }

    public IllegalOperationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public IllegalOperationException(Throwable throwable) {
        super(throwable);
    }
}
