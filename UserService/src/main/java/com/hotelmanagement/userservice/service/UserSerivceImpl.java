package com.hotelmanagement.userservice.service;

import com.hotelmanagement.userservice.customexceptionhandler.ResourceNotFoundException;
import com.hotelmanagement.userservice.customexceptionhandler.UsernameNotFoundException;
import com.hotelmanagement.userservice.entity.User;
import com.hotelmanagement.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSerivceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getbyUsername(String username) {

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
