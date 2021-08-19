package org.snetwork.handler;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.snetwork.exception.PictureNotFoundException;
import org.snetwork.model.PictureExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class FileExceptionHandler {
    @ExceptionHandler(value = { PictureNotFoundException.class, FileSizeLimitExceededException.class })
    public PictureExceptionResponse handleConversationNotFoundException(Exception exception, WebRequest request) {
        return PictureExceptionResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .path(request.getContextPath())
                .build();
    }

}
