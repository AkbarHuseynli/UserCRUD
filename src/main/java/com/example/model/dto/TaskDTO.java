package com.example.model.dto;

import java.time.LocalDate;

public record TaskDTO(
        String title,
        String description,
        LocalDate deadline
        ) {
}
