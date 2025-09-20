package com.ayrton.uberDesafio.dto;

import jakarta.validation.constraints.Email;

public record UserRequest(String fullName, String username, @Email String email,String phoneNumber,int numberRaces) {
}
