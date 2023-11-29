package com.example.registration;

import com.example.appuser.AppUserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<Integer> register(@RequestBody AppUserDTO request) {
        return ResponseEntity.ok(registrationService.register((request)));
    }
    @GetMapping
    public String login(){
        return "Signed in successfully";
    }

    @PostMapping("/confirmation")
    public ResponseEntity<String> confirmation(@JsonProperty Integer otpCode){
        return ResponseEntity.ok(registrationService.confirm(otpCode));
    }

    @PostMapping("/forgetMyPassword")
    public ResponseEntity<String> passwordUpdate(@RequestBody AppUserDTO request){
        return ResponseEntity.ok(registrationService.passwordUpdate(request));
    }
    @PostMapping("/rememberMe")
    public void rememberMe(){
        registrationService.rememberMe();
    }

}
