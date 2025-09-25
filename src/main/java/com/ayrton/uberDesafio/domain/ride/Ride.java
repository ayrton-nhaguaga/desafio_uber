package com.ayrton.uberDesafio.domain.ride;

import com.ayrton.uberDesafio.domain.driver.Driver;
import com.ayrton.uberDesafio.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "rides")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ride {

    @Id
    private String id;

    private User passenger;
    private Driver driver;

    private double originLat;
    private double originLng;

    private double destinationLat;
    private double destinationLng;

    private RideStatus rideStatus;

    private double price;

    private LocalDateTime requestedAt;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;

    private LocalDateTime canceledAt;
    private String cancelReason;
    private LocalDateTime acceptedAt;


}
