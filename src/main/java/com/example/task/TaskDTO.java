package com.example.task;

import java.time.LocalDateTime;

public record TaskDTO(String title,
        String description,
        LocalDateTime deadline
        ) {
}
