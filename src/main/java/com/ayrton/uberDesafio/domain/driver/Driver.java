package com.ayrton.uberDesafio.domain.driver;

import com.ayrton.uberDesafio.domain.user.UserSex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drivers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    private String id;

    private String fullName;
    private String email;
    private String age;
    private UserSex userSex;
    private int numberRaces;

    private String vehicleBrand;
    private String vehicleReference;
    private String vehicleColor;
    private String vehicleRegistration;
    private VehicleType vehicleType;

    private double currentLat;
    private  double currentLng;

    private DriverStatus driverStatus;

}
