package com.ayrton.uberDesafio.controller;

import com.ayrton.uberDesafio.domain.driver.Driver;
import com.ayrton.uberDesafio.domain.driver.VehicleType;
import com.ayrton.uberDesafio.domain.user.UserSex;
import com.ayrton.uberDesafio.dto.DriverRequest;
import com.ayrton.uberDesafio.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/create")
    public ResponseEntity<Driver> createDriver(@RequestBody DriverRequest driverRequest){
        Driver driver = driverService.createDriver(driverRequest);
        return new ResponseEntity<>(driver, HttpStatus.CREATED);
    }

    @GetMapping("/all_drivers")
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/fullName")
    public ResponseEntity<List<Driver>> getByFullName(@RequestParam String fullName){
        List<Driver> drivers = driverService.getByName(fullName);
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/vehicleType")
    public ResponseEntity<List<Driver>> getByVehicleType(@RequestParam VehicleType vehicleType){
        List<Driver> drivers = driverService.getByVehicleType(vehicleType);
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/sex")
    public ResponseEntity<List<Driver>> getByDriverSex(@RequestParam UserSex userSex){
        List<Driver> drivers = driverService.getByDriverSex(userSex);
        return ResponseEntity.ok(drivers);
    }
}
