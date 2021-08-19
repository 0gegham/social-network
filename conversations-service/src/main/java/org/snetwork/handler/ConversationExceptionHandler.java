package org.snetwork.handler;

import org.snetwork.exception.ConversationNotFoundException;
import org.snetwork.model.ConversationExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ConversationExceptionHandler {
    @ExceptionHandler(value = { ConversationNotFoundException.class })
    public ConversationExceptionResponse handleConversationNotFoundException(ConversationNotFoundException exception, WebRequest request) {
        return ConversationExceptionResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .path(request.getContextPath())
                .build();
    }
}
