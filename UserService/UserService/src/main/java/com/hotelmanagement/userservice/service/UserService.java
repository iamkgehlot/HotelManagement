package com.hotelmanagement.userservice.service;

import com.hotelmanagement.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUsers() ;

    User getbyUsername(String username);

    User save(User user);

    List<User> saveMul(List<User> user);
}
