package com.example.model.entity;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

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
    LocalDate deadline;
    @Enumerated(value = EnumType.STRING)
    TaskStatus taskStatus;
    @ManyToOne
    @JoinColumn(
            name = "category_id"
    )
    Category category;

    @Override
    public String toString() {
        return "Task{" +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", taskStatus=" + taskStatus +
                ", category=" + category.getName() +
                '}';
    }
}
