package com.example.myapplication.domain.usecase;

import com.example.myapplication.domain.model.Task;
import com.example.myapplication.domain.repository.TaskRepository;

public class AddTaskUseCase {
    private final TaskRepository taskRepository;

    public AddTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void execute(String title) {
        Task task = new Task(0, title, false);
        taskRepository.addTask(task);
    }
}

