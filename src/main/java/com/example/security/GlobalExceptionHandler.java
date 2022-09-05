package com.example.security;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Map<String, Object> body = new LinkedHashMap<>();

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleAuthenticationException(Exception e) {
        body.put("Timestamp", new Date());
        body.put("Status", HttpStatus.UNAUTHORIZED);
        body.put("Errors", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(Exception e) {
        body.put("Timestamp", new Date());
        body.put("Status", HttpStatus.FORBIDDEN);
        body.put("Errors", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> usernameNotFoundException(UsernameNotFoundException e) {
        body.put("Timestamp", new Date());
        body.put("Status", HttpStatus.NOT_FOUND);
        body.put("Errors", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    //bắt xử lý ngoại lệ
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<?> numberFormatException(NumberFormatException e){
        body.put("Timestamp", new Date());
        body.put("Status", HttpStatus.BAD_REQUEST);
        body.put("Errors", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> illegalStateException(NumberFormatException e){
        body.put("Timestamp", new Date());
        body.put("Status", HttpStatus.BAD_REQUEST);
        body.put("Errors", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        body.put("Timestamp", new Date());
        body.put("Status", status.value());
        //get all error
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("Errors", errors);
        return new ResponseEntity<>(body, headers, status);
    }
}
