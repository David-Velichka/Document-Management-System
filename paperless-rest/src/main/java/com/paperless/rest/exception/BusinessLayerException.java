package com.paperless.rest.exception;

public class BusinessLayerException extends RuntimeException {
    public BusinessLayerException(String message) {
        super(message);
    }

    public BusinessLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
