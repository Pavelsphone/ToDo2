package com.example.myapplication.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.domain.model.Task;
import com.example.myapplication.domain.usecase.AddTaskUseCase;
import com.example.myapplication.domain.usecase.GetTasksUseCase;
import com.example.myapplication.data.repository.TaskRepositoryImpl;
import java.util.List;

public class TaskViewModel extends ViewModel {
    private final MutableLiveData<List<Task>> tasksLiveData = new MutableLiveData<>();
    private final GetTasksUseCase getTasksUseCase;
    private final AddTaskUseCase addTaskUseCase;

    public TaskViewModel() {
        TaskRepositoryImpl repository = new TaskRepositoryImpl();
        this.getTasksUseCase = new GetTasksUseCase(repository);
        this.addTaskUseCase = new AddTaskUseCase(repository);
        loadTasks();
    }

    public LiveData<List<Task>> getTasks() {
        return tasksLiveData;
    }

    public void loadTasks() {
        List<Task> tasks = getTasksUseCase.execute();
        tasksLiveData.setValue(tasks);
    }

    public void addTask(String title) {
        addTaskUseCase.execute(title);
        loadTasks();
    }
}
