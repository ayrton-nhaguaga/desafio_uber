package com.ayrton.uberDesafio.service;

import com.ayrton.uberDesafio.domain.user.User;
import com.ayrton.uberDesafio.dto.UserRequest;
import com.ayrton.uberDesafio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getById(String id){
        return userRepository.findById(id);
    }

    public void  saveUser(User user){
        this.userRepository.save(user);
    }

    final int STARTING_RACES = 0;

    public User createUser(UserRequest userRequest){
        User user = new User();
        user.setFullName(userRequest.fullName());
        user.setUsername(userRequest.username());
        user.setEmail(userRequest.email());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setRole(User.Role.USER);
        user.setNumberRaces(STARTING_RACES);
        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }
}
