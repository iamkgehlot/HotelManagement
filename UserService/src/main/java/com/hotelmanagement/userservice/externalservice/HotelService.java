package com.hotelmanagement.userservice.externalservice;

import com.hotelmanagement.userservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HotelService")
public interface HotelService {

    @GetMapping("/hotel/get-hotel/{hotelId}")
    Hotel getHotelById(@PathVariable int hotelId );
}
