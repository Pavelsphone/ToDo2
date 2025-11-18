package com.example.myapplication.data.repository;

import com.example.myapplication.domain.model.Task;
import com.example.myapplication.domain.repository.TaskRepository;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public TaskRepositoryImpl() {
        tasks.add(new Task(nextId++, "Купить молоко", false));
        tasks.add(new Task(nextId++, "Позвонить другу", true));
        tasks.add(new Task(nextId++, "Записаться к врачу", false));
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public void addTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
    }
}

