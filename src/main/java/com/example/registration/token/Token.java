package com.example.registration.token;

import com.example.appuser.AppUser;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Token {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    Integer otpCode;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    AppUser appUser;
}
