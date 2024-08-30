package com.hotelmanagement.userservice.customexceptionhandler;

import lombok.AllArgsConstructor;


public class UsernameNotFoundException extends RuntimeException{

    public UsernameNotFoundException(String message){
        super(message);
    }
    public UsernameNotFoundException(){
        super("user name not found");
    }

}
