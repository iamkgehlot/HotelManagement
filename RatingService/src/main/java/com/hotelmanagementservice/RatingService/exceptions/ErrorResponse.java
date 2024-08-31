package com.hotelmanagementservice.RatingService.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private HttpStatus httpStatus;
}
