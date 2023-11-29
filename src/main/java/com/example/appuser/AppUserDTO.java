package com.example.appuser;

import jakarta.validation.constraints.Pattern;

public record AppUserDTO(String firstName,
                         String lastName,
                         String email,
                         @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-+=])(.{6,})$")
                         String password) {


}
