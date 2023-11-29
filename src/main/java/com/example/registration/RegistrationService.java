package com.example.registration;

import com.example.appuser.*;
import com.example.email.EmailService;
import com.example.registration.token.Token;
import com.example.registration.token.TokenService;
import com.example.security.config.SecurityConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    private final AppUserMapper appUserMapper;
    private final EmailService emailService;
    private final TokenService tokenService;
    private Integer otpCode;

    public Integer register(AppUserDTO request) {
        boolean isValidEmail = emailValidator.test(request.email());
        if (!isValidEmail) {
            log.error("Email is not valid!");
            throw new IllegalStateException("email is not valid!");
        }
        AppUser appUser = appUserMapper.appUsertoAppUserDTO(request);
        appUser.setAppUserRole(AppUserRole.USER);
        appUser.setEnabled(false);
        appUserService.signUpUser(appUser);

        // SAVING TOKEN
        otpCode = generateNumber();
        Token otpToken = Token.builder().otpCode(otpCode).appUser(appUser).build();
        tokenService.saveToken(otpToken);
        emailService.send(appUser.getEmail(), "Registration confirmation", otpToken.getOtpCode().toString());

        return otpToken.getOtpCode();
    }

    public String confirm(Integer otpCode) {
        if (otpCode.equals(this.otpCode)) {
            tokenService.getToken(otpCode).getAppUser().setEnabled(true);
        } else {
            throw new IllegalStateException("OTP code is not valid!");
        }
        return "Registration completed successfully!";
    }

    private Integer generateNumber() {
        Random random = new Random();
        int sixDigitNumber = random.nextInt(900000) + 100000;
        return sixDigitNumber;
    }

    public String passwordUpdate(AppUserDTO appUserDTO) {

        AppUser appUser = appUserService.findByEmail(appUserDTO.email());

        appUserService.passwordUpdate(appUser, appUserDTO.password());

        emailService.send(appUser.getEmail(), "Account credentials updated", "Account's password got successfully updated!");

        return "Password changed successfully!";

    }

    public void rememberMe() {
        SecurityConfig.sessionCreationPolicy = SessionCreationPolicy.ALWAYS;
        log.info("User session is set up");
    }
}

