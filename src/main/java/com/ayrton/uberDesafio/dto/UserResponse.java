package com.ayrton.uberDesafio.dto;

import jakarta.validation.constraints.Email;

public record UserResponse(String fullName, @Email String email, String phoneNumber) {
}
