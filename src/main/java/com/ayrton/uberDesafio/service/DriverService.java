package com.ayrton.uberDesafio.service;

import com.ayrton.uberDesafio.domain.driver.Driver;
import com.ayrton.uberDesafio.domain.user.User;
import com.ayrton.uberDesafio.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Optional<Driver> getById(String id){
        return this.driverRepository.findById(id);
    }

    public  void saveDriver(Driver driver){
        this.driverRepository.save(driver);
    }
}
