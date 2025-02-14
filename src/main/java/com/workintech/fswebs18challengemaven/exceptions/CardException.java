package com.workintech.fswebs18challengemaven.exceptions;

import org.springframework.http.HttpStatus;

public class CardException extends RuntimeException {
    private final HttpStatus httpStatus;

    public CardException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public CardException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
