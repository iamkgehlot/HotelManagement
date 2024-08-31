package com.hotelmanagement.HotelService.service;

import com.hotelmanagement.HotelService.entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    List<Hotel> getAllHotel();
    Hotel getHotelByid(int hotelId);
    Hotel createHotel(Hotel hotel);
    List<Hotel> insertMultipleHotels(List<Hotel> hotelList);

}
