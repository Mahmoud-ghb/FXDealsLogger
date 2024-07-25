package com.example.FXDealsLogger.exception;

public class DealAlreadyExistsException extends RuntimeException {
    public DealAlreadyExistsException(String message) {
        super(message);
    }
    public DealAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
