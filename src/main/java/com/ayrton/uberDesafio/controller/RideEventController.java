package com.ayrton.uberDesafio.controller;

import com.ayrton.uberDesafio.domain.driver.Driver;
import com.ayrton.uberDesafio.dto.LocationDTO;
import com.ayrton.uberDesafio.service.RideService; // Novo import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class RideEventController {

    @Autowired
    private RideService rideService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/ride")
    public void broadcastRide(LocationDTO location) {
        // Filtra motoristas próximos usando a service
        var nearbyDrivers = rideService.findNearbyDrivers(location.getLatitude(), location.getLongitude());

        // Em vez de broadcast global, envia para cada motorista próximo (user-specific)
        for (Driver driver : nearbyDrivers) {
            // Assumindo que LocationDTO tem um campo rideId ou similar; ajuste conforme necessário
            messagingTemplate.convertAndSendToUser (
                    driver.getId().toString(),  // User destination: /user/{driverId}/rides
                    "/rides",
                    location
            );
        }
    }
}
