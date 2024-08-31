package com.hotelmanagement.HotelService.exceptionHandler.errorResponse;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ErrorResponse {
    HttpStatus httpStatus;
    String error;
}
