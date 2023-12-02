package com.example.repository;

import com.example.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByOtpCode(Integer otpCode);

}
