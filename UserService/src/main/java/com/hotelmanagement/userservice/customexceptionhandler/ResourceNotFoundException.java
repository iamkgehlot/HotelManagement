package com.hotelmanagement.userservice.customexceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String error) {
        super(error);
    }
    public ResourceNotFoundException(){
        super("Resource Not Found not server, Kindly Check data");
    }
}
