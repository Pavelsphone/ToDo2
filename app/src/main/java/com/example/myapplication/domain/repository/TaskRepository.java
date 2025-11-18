package com.example.myapplication.domain.repository;

import com.example.myapplication.domain.model.Task;
import java.util.List;

public interface TaskRepository {
    List<Task> getTasks();
    void addTask(Task task);
}

