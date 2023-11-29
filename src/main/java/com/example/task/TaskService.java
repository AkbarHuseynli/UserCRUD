package com.example.task;

import com.example.appuser.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final AppUserService appUserService;

    public void addTask(TaskDTO taskDTO, long userId) {
        Task task = taskMapper.taskDTOtoTask(taskDTO);
        task.setTaskStatus(TaskStatus.TODO);
        taskRepository.save(task);
        appUserService.addTask(task, userId);
    }
    public void deleteTask(long taskId) {
        taskRepository.deleteById(taskId);
        log.info("Task deleted successfully!");
    }
    public void editTask(TaskDTO taskDTO) {
        Task task = taskMapper.taskDTOtoTask(taskDTO);
        taskRepository.save(task);
    }
    public void markTaskAsCompleted(long taskId) {
        Task task = taskRepository
                .findById(taskId)
                .orElseThrow(()->new IllegalStateException("task couldnt be found!"));
        task.setTaskStatus(TaskStatus.COMPLETED);
        taskRepository.save(task);
    }
    public List<Task> filterByCategory(long userId, String categoryName){
        return taskRepository.findAllByAppUser_IdAndCategory_Name(userId, categoryName);
    }
}
