package com.example.appuser;

import com.example.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appUser")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping("/showTaskToDo/{userId}")
    public List<Task> showTasksToDo(@PathVariable long userId) {
        return appUserService.showTasksToDo(userId);
    }
}
