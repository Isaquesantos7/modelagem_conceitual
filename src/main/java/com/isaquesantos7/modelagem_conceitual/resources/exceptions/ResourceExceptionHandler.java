package com.isaquesantos7.modelagem_conceitual.resources.exceptions;

import com.isaquesantos7.modelagem_conceitual.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandError standError = new StandError(System.currentTimeMillis(), status.value(), "Object not found!", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standError);
    }
}
