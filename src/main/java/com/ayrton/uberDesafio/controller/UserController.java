package com.ayrton.uberDesafio.controller;

import com.ayrton.uberDesafio.domain.user.User;
import com.ayrton.uberDesafio.dto.UserRequest;
import com.ayrton.uberDesafio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest){
        User user = userService.createUser(userRequest);
        return  new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
