package com.example.repository;

import com.example.model.entity.AppUser;
import com.example.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
    @Query(value = "SELECT ut.t FROM user_tasks ut " +
            "JOIN user_tasks ut ON t.id = ut.task_id " +
            "JOIN app_user au ON au.id = ut.user_id " +
            "WHERE au.id = :userId AND t.task_status =:status", nativeQuery = true)
    List<Task> findTasksByUserId(@Param("userId") long userId, @Param("status") String status);

}
