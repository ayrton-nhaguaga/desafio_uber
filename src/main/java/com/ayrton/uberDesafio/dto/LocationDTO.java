package com.ayrton.uberDesafio.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private double latitude;
    private double longitude;
    private String driverId; // id do driver ou passageiro
}
