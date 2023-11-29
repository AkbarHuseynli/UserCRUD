package com.example.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/addTask/{userId}")
    public void addTask( @PathVariable long userId, @RequestBody TaskDTO taskDTO){
        taskService.addTask(taskDTO, userId);
    }

    @PostMapping("/deleteTask/{taskId}")
    public void deleteTask(@PathVariable long taskId){
        taskService.deleteTask(taskId);
    }

    @PostMapping("/editTask")
    public void editTask(@RequestBody TaskDTO taskDTO){
        taskService.editTask(taskDTO);
    }

    @PostMapping("/taskDone/{taskId}")
    public void markTaskAsCompleted(@PathVariable long taskId){
        taskService.markTaskAsCompleted(taskId);
    }

    @GetMapping("/filter/{userId}")
    public List<Task> filterTaskAsCategory(@PathVariable long userId, @JsonProperty String categoryTitle) {
        return taskService.filterByCategory(userId, categoryTitle);
    }

}
