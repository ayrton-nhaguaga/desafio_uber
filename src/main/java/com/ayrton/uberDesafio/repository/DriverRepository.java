package com.ayrton.uberDesafio.repository;

import com.ayrton.uberDesafio.domain.driver.Driver;
import com.ayrton.uberDesafio.domain.driver.DriverStatus;
import com.ayrton.uberDesafio.domain.driver.VehicleType;
import com.ayrton.uberDesafio.domain.user.UserSex;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends MongoRepository<Driver, String> {
    List<Driver> findByFullNameContainsIgnoreCase(String name);

    List<Driver> findByVehicleType(VehicleType vehicleType);

    List<Driver> findByUserSex(UserSex userSex);

    List<Driver> findByDriverStatus(DriverStatus driverStatus);
}
