package com.example.appuser;

import com.example.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
    @Query(value = "SELECT t.* FROM tasks t " +
            "JOIN user_tasks ut ON t.id = ut.task_id " +
            "JOIN users u ON u.id = ut.user_id " +
            "WHERE u.id = :userId", nativeQuery = true)
    List<Task> findTasksByUserId(@Param("userId") Long userId);

}
