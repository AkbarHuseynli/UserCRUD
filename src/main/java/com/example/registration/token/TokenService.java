package com.example.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    public void saveToken(Token token) {
        tokenRepository.save(token);
    }

    public Token getToken(Integer token) {
        return tokenRepository.findByOtpCode(token).orElseThrow(()->new IllegalStateException("Token couldnt be found!"));
    }

}