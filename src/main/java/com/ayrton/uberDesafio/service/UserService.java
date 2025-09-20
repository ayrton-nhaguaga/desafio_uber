package com.ayrton.uberDesafio.service;

import com.ayrton.uberDesafio.domain.user.User;
import com.ayrton.uberDesafio.dto.UserResponse;
import com.ayrton.uberDesafio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
