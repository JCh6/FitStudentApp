package com.fitstudentapp.server.exceptions;

import com.fitstudentapp.server.shared.Utils;
import com.fitstudentapp.server.ui.model.response.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.logging.Logger;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = Logger.getLogger(AppExceptionHandler.class.getName());

    @Autowired
    Utils utils;

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String message = utils.extractMessage(ex);

        return new ResponseEntity<>(
                new ErrorMessage(new Date(), message),
                new HttpHeaders(),
                INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = { ConstraintViolationException.class })
    public ResponseEntity<Object> handleAnyException(ConstraintViolationException ex, WebRequest request) {

        return new ResponseEntity<>(
                new ErrorMessage(),
                new HttpHeaders(),
                BAD_REQUEST
        );
    }

    @ExceptionHandler(value = { NoContentException.class })
    public ResponseEntity<Object> handleNoContextException(NoContentException ex, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorMessage(),
                new HttpHeaders(),
                NO_CONTENT
        );
    }

    @ExceptionHandler(value = { NotFoundException.class })
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
        String message = utils.extractMessage(ex);

        return new ResponseEntity<>(
                new ErrorMessage(new Date(), message),
                new HttpHeaders(),
                NOT_FOUND
        );
    }

}
