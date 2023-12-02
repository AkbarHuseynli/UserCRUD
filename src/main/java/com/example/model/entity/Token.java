package com.example.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

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
