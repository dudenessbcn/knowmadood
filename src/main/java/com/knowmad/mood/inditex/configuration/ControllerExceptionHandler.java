package com.knowmad.mood.inditex.configuration;

import com.knowmad.mood.inditex.configuration.exception.PriceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by dani on 11/26/24
 */

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            IllegalArgumentException.class,
            IllegalStateException.class,
            PriceNotFoundException.class
    })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request
    ) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex,
                bodyOfResponse,
                new HttpHeaders(),
                HttpStatus.CONFLICT, request);
    }
}
