package com.example.controller;

import com.example.model.dto.AppUserDTO;
import com.example.service.RegistrationService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @Synchronized
    @PostMapping("/register")
    public ResponseEntity<Integer> register(@RequestBody AppUserDTO request) {
        return ResponseEntity.ok(registrationService.register((request)));
    }

    @GetMapping("/login")
    public String login() {
        return "Signed in successfully";
    }

    @PostMapping("/confirmation")
    public ResponseEntity<String> confirmation(@JsonProperty Integer otpCode) {
        return ResponseEntity.ok(registrationService.confirm(otpCode));
    }

    @PostMapping("/forgetMyPassword")
    public ResponseEntity<String> passwordUpdate(@RequestBody AppUserDTO request) {
        return ResponseEntity.ok(registrationService.passwordUpdate(request));
    }

    @PostMapping("/rememberMe")
    public void rememberMe() {
        registrationService.rememberMe();
    }

}
