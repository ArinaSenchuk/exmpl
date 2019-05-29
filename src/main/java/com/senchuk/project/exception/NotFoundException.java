package com.senchuk.project.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

    private final HttpStatus status;

    public HttpStatus getStatus() {
        return status;
    }

    public NotFoundException(String message) {
        super(message);
        this.status = HttpStatus.NOT_FOUND;
    }
}
