package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        final String[] message = {""};
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            message[0] = error.getDefaultMessage();
        });
        return new ErrorResponse(message[0], HttpStatus.NO_CONTENT, ZonedDateTime.now());
    }
    @ExceptionHandler(value= IllegalStateException.class)
    public ErrorResponse handleIllegalStateException(IllegalStateException exception){
      return new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
    }

}
