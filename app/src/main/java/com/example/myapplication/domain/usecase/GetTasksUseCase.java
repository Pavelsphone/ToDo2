package com.example.myapplication.domain.usecase;

import com.example.myapplication.domain.model.Task;
import com.example.myapplication.domain.repository.TaskRepository;
import java.util.List;

public class GetTasksUseCase {
    private final TaskRepository taskRepository;

    public GetTasksUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> execute() {
        return taskRepository.getTasks();
    }
}

