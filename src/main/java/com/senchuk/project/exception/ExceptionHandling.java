package com.senchuk.project.exception;

import com.senchuk.project.model.exception.UnexpectedError;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public Object notFoundExceptionHandler(NotFoundException e, WebRequest request) {
        final UnexpectedError error = new UnexpectedError();
        error.setMessage(e.getMessage());
        return handleExceptionInternal(e, error, new HttpHeaders(), e.getStatus(), request);
    }

}
