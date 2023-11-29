package com.example.appuser;

import com.example.task.Task;
import com.example.task.TaskDTO;
import com.example.task.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExists) {
            log.error("Email already is taken!");
            throw new IllegalStateException("");
        }
        String password = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(password);
        appUser.setLocked(false);

        appUserRepository.save(appUser);

        return "it works";
    }

    public void passwordUpdate(AppUser appUser, String password) {
        password = passwordEncoder.encode(password);
        appUser.setPassword(password);
        appUserRepository.save(appUser);
    }

    public AppUser findByEmail(String email) {
        return appUserRepository.findByEmail(email).orElseThrow(() -> new IllegalStateException("Email couldnt be found!"));
    }

    public void addTask(Task task, long userId) {
        AppUser appUser = appUserRepository
                .findById(userId)
                .orElseThrow(()->new IllegalStateException("User couldnt be found!"));

        List<Task> taskList = appUser.getTasks();
        taskList.add(task);
        appUser.setTasks(taskList);
        appUserRepository.save(appUser);
        log.info("Task added to the "+appUser.getFirstName()+"'s list");

    }

    public List<Task> showTasksToDo(long userId) {
        return appUserRepository.findTasksByUserId(userId);
    }

}
