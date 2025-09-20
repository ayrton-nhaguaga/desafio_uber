package com.ayrton.uberDesafio.dto;

import com.ayrton.uberDesafio.domain.driver.VehicleType;
import com.ayrton.uberDesafio.domain.user.UserSex;

public record DriverRequest(String fullName, String email, String age, UserSex userSex, String vehicleBrand, String vehicleReference, String vehicleColor, String vehicleRegistration, VehicleType vehicleType) {
}
