package com.university.exceptions;

@SuppressWarnings("serial")
public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
