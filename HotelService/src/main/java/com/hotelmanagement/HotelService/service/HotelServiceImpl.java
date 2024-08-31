package com.hotelmanagement.HotelService.service;

import com.hotelmanagement.HotelService.entity.Hotel;
import com.hotelmanagement.HotelService.exceptionHandler.HotelIdNotfoundExceptionClass;
import com.hotelmanagement.HotelService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel getHotelByid(int hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new HotelIdNotfoundExceptionClass(hotelId+" this id does not exists"));
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> insertMultipleHotels(List<Hotel> hotelList) {
        return hotelRepository.saveAll(hotelList);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }


}
