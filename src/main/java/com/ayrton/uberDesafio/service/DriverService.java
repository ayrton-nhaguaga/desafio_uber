package com.ayrton.uberDesafio.service;

import com.ayrton.uberDesafio.domain.driver.Driver;
import com.ayrton.uberDesafio.dto.DriverRequest;
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

    final int STARTING_RACES = 0;// Numero inicial de corridas ao cadastrar um driver

    public Driver createDriver(DriverRequest driverRequest){
        Driver driver = new Driver();
        driver.setFullName(driverRequest.fullName());
        driver.setEmail(driverRequest.email());
        driver.setAge(driverRequest.age());
        driver.setUserSex(driverRequest.userSex());
        driver.setNumberRaces(STARTING_RACES);
        driver.setVehicleBrand(driverRequest.vehicleBrand());
        driver.setVehicleReference(driverRequest.vehicleReference());
        driver.setVehicleColor(driverRequest.vehicleColor());
        driver.setVehicleType(driverRequest.vehicleType());

        return driverRepository.save(driver);
    }
}
