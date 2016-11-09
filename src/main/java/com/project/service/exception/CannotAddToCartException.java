package com.project.service.exception;

public class CannotAddToCartException extends RuntimeException {

    public CannotAddToCartException() {
        super();
    }

    public CannotAddToCartException(String message) {
        super(message);
    }

    public CannotAddToCartException(String message, Throwable cause) {
        super(message, cause);
    }

    public CannotAddToCartException(Throwable cause) {
        super(cause);
    }

    protected CannotAddToCartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
