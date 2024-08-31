package com.hotelmanagementservice.RatingService.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> customResurceNotFoundException(ResourceNotFoundException ex){
        ErrorResponse errorResponse=ErrorResponse.builder().message(ex.getMessage()).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
