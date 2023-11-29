package com.example.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    void deleteById(Long aLong);
    List<Task> findAllByAppUser_IdAndCategory_Name(long appUserId, String categoryName);
}
