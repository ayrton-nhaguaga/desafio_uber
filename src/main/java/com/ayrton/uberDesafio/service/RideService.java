package com.ayrton.uberDesafio.service;

import com.ayrton.uberDesafio.domain.driver.Driver;
import com.ayrton.uberDesafio.domain.driver.DriverStatus;
import com.ayrton.uberDesafio.domain.ride.Ride;
import com.ayrton.uberDesafio.domain.ride.RideStatus;
import com.ayrton.uberDesafio.domain.user.User;
import com.ayrton.uberDesafio.dto.RideRequest;
import com.ayrton.uberDesafio.repository.RideRepository;
import com.ayrton.uberDesafio.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DriverService driverService;



    public boolean authorizeRide(User passenger, Driver driver) {
        return passenger.getStatus() == User.Status.ACTIVE
                && driver.getDriverStatus() == DriverStatus.AVAILABLE;
    }

    public Ride createRide(RideRequest rideRequest) {
        User passenger = userService.getById(rideRequest.passengerId())
                .orElseThrow(() -> new IllegalArgumentException("Passageiro não encontrado"));

        Driver driver = driverService.getById(rideRequest.driverId())
                .orElseThrow(() -> new IllegalArgumentException("Motorista não encontrado"));

        boolean authorized = this.authorizeRide(passenger, driver);

        if (!authorized) {
            throw new IllegalStateException("Não pode solicitar uma viagem");
        }


        Ride newRide = new Ride();
        newRide.setPassenger(passenger);
        newRide.setDriver(driver);
        newRide.setOriginLat(rideRequest.originLat());
        newRide.setOriginLng(rideRequest.originLng());
        newRide.setDestinationLat(rideRequest.destinationLat());
        newRide.setDestinationLng(rideRequest.destinationLng());
        newRide.setRideStatus(RideStatus.REQUESTED);
        newRide.setPrice(rideRequest.price());
        newRide.setRequestedAt(LocalDateTime.now());

        this.rideRepository.save(newRide);

        return newRide;

    }

    public Ride cancelRide(String rideId, String reason, User requester){
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new ResourceNotFoundException("Corrida não encontrada"));

        if (ride.getRideStatus() == RideStatus.COMPLETED) {
            throw new IllegalStateException("Não é possível cancelar uma corrida já finalizada");
        }
        if (ride.getRideStatus() == RideStatus.CANCELED) {
            return ride;
        }


        ride.setRideStatus(RideStatus.CANCELED);
        ride.setCanceledAt(LocalDateTime.now());
        ride.setCancelReason(reason);

        return rideRepository.save(ride);
    }

    public Ride completeRace(String rideId){
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new ResourceNotFoundException("Corrida não encontrada"));



        if (ride.getRideStatus() == RideStatus.CANCELED) {
            throw new IllegalStateException("Não é possível completar uma corrida cancelada");
        }

        if (ride.getRideStatus() == RideStatus.COMPLETED) {
            return ride;
        }

        User passenger = ride.getPassenger();
        passenger.setNumberRaces(passenger.getNumberRaces() + 1);

        Driver driver = ride.getDriver();
        driver.setNumberRaces(driver.getNumberRaces() + 1);

        ride.setRideStatus(RideStatus.COMPLETED);
        ride.setCompletedAt(LocalDateTime.now());

        this.rideRepository.save(ride);
        this.driverService.saveDriver(driver);
        this.userService.saveUser(passenger);

        return rideRepository.save(ride);
    }


}
