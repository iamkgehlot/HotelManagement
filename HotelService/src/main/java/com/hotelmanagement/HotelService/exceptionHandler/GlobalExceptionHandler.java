package com.hotelmanagement.HotelService.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(HotelIdNotfoundExceptionClass.class)
    public ResponseEntity<Map<String,Object>> hotelNotFoundExceptonHandler(HotelIdNotfoundExceptionClass ex){
       // ErrorResponse errorResponse=ErrorResponse.builder().httpStatus(HttpStatus.NOT_FOUND).error(ex.getMessage()).build();
        Map<String,Object> map=new HashMap<>();
        map.put("message",ex.getMessage());
        map.put("status",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
    }
}
