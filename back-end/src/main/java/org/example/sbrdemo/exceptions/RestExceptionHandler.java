package org.example.sbrdemo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult()
                .getAllErrors()
                .forEach((error) -> errors.put(error.getDefaultMessage(), error.getDefaultMessage()));

        return errors;
    }
    private ResponseEntity<Object> buildResponseEntity(ApiException apiException) {
        return new ResponseEntity<>(apiException, apiException.getStatus());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundException(ResourceNotFoundException exception) {
        ApiException apiException = new ApiException(NOT_FOUND
                , exception.getMessage(), LocalDateTime.now());
        return buildResponseEntity(apiException);
    }

    @ExceptionHandler({StudentAlreadyExistsException.class})
    protected ResponseEntity<Object> handleConflictException(StudentAlreadyExistsException exception) {
        ApiException apiException = new ApiException(CONFLICT
                , exception.getMessage(), LocalDateTime.now());
        return buildResponseEntity(apiException);
    }
}
