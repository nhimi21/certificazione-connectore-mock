package com.eng.api.certificazionidoc.exception;

import com.eng.api.certificazionidoc.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CertificazioniException.class)
    public ErrorDto handlerBusinessException(CertificazioniException ex, HttpServletRequest request) {

        ErrorDto errorDto = new ErrorDto();
        errorDto.setError(ex.getErrorCode().getMessage());
        errorDto.setStatus(500);
        errorDto.setTimeStamp(new Date());
        errorDto.setMessage(ex.getMessage());
        errorDto.setPath(request.getRequestURI());

        return errorDto;
    }
}