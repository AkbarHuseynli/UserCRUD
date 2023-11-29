package com.example.task;

import com.example.appuser.AppUser;
import com.example.task.category.Category;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    String title;
    String description;
    String priority;
    LocalDateTime deadline;
    TaskStatus taskStatus;
    @ManyToOne
    @JoinColumn(
            name = "category_id"
    )
    Category category;

    @ManyToOne
    @JoinColumn(
            name = "app_user_id"
    )
    AppUser appUser;

}
