package com.example.repository;

import com.example.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    void deleteById(Long aLong);
    @Query(value = "SELECT t.* FROM task t " +
            "JOIN user_tasks ut ON t.id = ut.task_id " +
            "JOIN app_user au ON ut.user_id = au.id " +
            "JOIN category c ON t.category_id = c.id " +
            "WHERE au.id = :userId AND c.name = :categoryName", nativeQuery = true)
    List<Task> findAllByFilter(@Param("userId") long userId, @Param("categoryName") String categoryName);
}
