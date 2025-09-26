package com.ayrton.uberDesafio.service;

import com.ayrton.uberDesafio.domain.driver.Driver;
import com.ayrton.uberDesafio.domain.driver.DriverStatus;
import com.ayrton.uberDesafio.domain.driver.VehicleType;
import com.ayrton.uberDesafio.domain.user.UserSex;
import com.ayrton.uberDesafio.dto.DriverRequest;
import com.ayrton.uberDesafio.repository.DriverRepository;
import com.ayrton.uberDesafio.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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


    public List<Driver> getAllDrivers() throws ResourceNotFoundException{
        List<Driver> drivers = driverRepository.findAll();

        if (drivers.isEmpty()){
            throw new ResourceNotFoundException("Nenhum motorista encontrado");
        }
        return drivers;
    }

    public List<Driver> getByName(String fullName) throws  ResourceNotFoundException{
        List<Driver> drivers = driverRepository.findByFullNameContainsIgnoreCase(fullName);

        if (drivers.isEmpty()){
            throw  new ResourceNotFoundException("Nenhum motorista encontrado");
        }
        return  drivers;
    }

    public List<Driver> getByVehicleType(VehicleType vehicleType) throws ResourceNotFoundException{
        List<Driver> drivers = driverRepository.findByVehicleType(vehicleType);

        if (drivers.isEmpty()){
            throw new ResourceNotFoundException("Nenhum motorista encontrado");
        }
        return drivers;
    }

    public List<Driver> getByDriverSex(UserSex userSex) throws  ResourceNotFoundException{
        List<Driver> drivers = driverRepository.findByUserSex(userSex);

        if (drivers.isEmpty()){
            throw new ResourceNotFoundException("Nenhum motorista encontrado");
        }
        return drivers;
    }

    public List<Driver> getByStatus(DriverStatus driverStatus)throws ResourceNotFoundException{
        List<Driver> drivers = driverRepository.findByDriverStatus(driverStatus);

        if (drivers.isEmpty()){
            throw new ResourceNotFoundException("Nenhum motorista encontrado");
        }
        return drivers;
    }
}
