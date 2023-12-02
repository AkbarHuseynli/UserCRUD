package com.example.controller;

import com.example.service.AppUserService;
import com.example.model.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping("/showTasks/{userId}")
    public List<Task> showTasksToDo(@PathVariable long userId) {
        return appUserService.showTasksToDo(userId);
    }
}
