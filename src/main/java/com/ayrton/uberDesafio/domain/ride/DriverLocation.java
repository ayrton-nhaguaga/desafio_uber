package com.ayrton.uberDesafio.domain.ride;

import com.ayrton.uberDesafio.domain.driver.DriverStatus;
import com.ayrton.uberDesafio.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "driver_locations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverLocation {

    @Id
    private String id;

    private User driver;

    private double latitude;
    private  double longitude;

    private DriverStatus driverStatus;
}
