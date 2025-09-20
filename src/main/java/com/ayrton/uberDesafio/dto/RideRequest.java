package com.ayrton.uberDesafio.dto;

import com.ayrton.uberDesafio.domain.ride.Ride;
import com.ayrton.uberDesafio.domain.ride.RideStatus;

import java.time.LocalDateTime;

public record RideRequest(String passengerId,
                          String driverId,
                          double originLat,
                          double originLng,
                          double destinationLat,
                          double destinationLng,
                          RideStatus rideStatus,
                          double price,
                          LocalDateTime requestedAt) {
}
