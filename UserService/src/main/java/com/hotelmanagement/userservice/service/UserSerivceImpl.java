package com.hotelmanagement.userservice.service;

import com.hotelmanagement.userservice.customexceptionhandler.ResourceNotFoundException;
import com.hotelmanagement.userservice.customexceptionhandler.UsernameNotFoundException;
import com.hotelmanagement.userservice.entity.Hotel;
import com.hotelmanagement.userservice.entity.Rating;
import com.hotelmanagement.userservice.entity.User;
import com.hotelmanagement.userservice.externalservice.HotelService;
import com.hotelmanagement.userservice.externalservice.RatingService;
import com.hotelmanagement.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserSerivceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    HotelService hotelService;

    @Autowired
    RatingService ratingService;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getbyUsername(String username) {
        User user =userRepository.findByUsername(username).orElseThrow(()-> new ResourceNotFoundException("Username: "+username+" not found"));

        List<Rating> rating= ratingService.getRatingByUserId(user.getUsername());
        List<Rating> ratingList=rating.stream().map(ratings->{

            Hotel hotel= hotelService.getHotelById(ratings.getHotelId());
            ratings.setHotel(hotel);
            return ratings;
        }).collect(Collectors.toList());
        user.setRating(rating);

        return userRepository.findByUsername(username).orElseThrow(()-> new ResourceNotFoundException("Username: "+username+" not found"));
    }

    @Override
    public User save(User user) {
        if(userRepository.existsByUsername(user.getUsername())){
            throw new UsernameNotFoundException("UserName "+user.getUsername()+" already exists");
        }

        return userRepository.save(user);
    }

    @Override
    public List<User> saveMul(List<User> user) {
        return userRepository.saveAll(user);
    }
}
