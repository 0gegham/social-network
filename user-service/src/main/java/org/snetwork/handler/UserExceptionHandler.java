package org.snetwork.handler;

import org.snetwork.exception.UsernameNotFoundException;
import org.snetwork.model.UserExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = { UsernameNotFoundException.class })
    public UserExceptionResponse handleUsernameNotFoundException(UsernameNotFoundException exception, WebRequest request) {
        return UserExceptionResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .path(request.getContextPath())
                .build();
    }

}
