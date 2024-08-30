package com.hotelmanagement.userservice.customexceptionhandler;

import com.hotelmanagement.userservice.payload.ErrorResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler{


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseEntity> globalException(ResourceNotFoundException ex){
        ErrorResponseEntity errorResponseEntity= ErrorResponseEntity.builder().errorCode(HttpStatus.NOT_FOUND).message(ex.getMessage()).build();
        return new ResponseEntity<>(errorResponseEntity, HttpStatus.NOT_FOUND);}

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponseEntity> UserNameNotFoundHandler(UsernameNotFoundException ex){
        return new ResponseEntity<>(ErrorResponseEntity.builder().message(ex.getMessage()).errorCode(HttpStatus.NOT_ACCEPTABLE).build(),HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseEntity> duplicateData(DataIntegrityViolationException ex){
        return new ResponseEntity<>(ErrorResponseEntity.builder().message("duplicate data entered").errorCode(HttpStatus.CONFLICT).build(),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseEntity> unknownExceptionHandler(Exception ex, WebRequest webRequest){
        return new ResponseEntity<>(ErrorResponseEntity.builder().message(ex.getMessage()).errorCode(HttpStatus.INTERNAL_SERVER_ERROR).build(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
