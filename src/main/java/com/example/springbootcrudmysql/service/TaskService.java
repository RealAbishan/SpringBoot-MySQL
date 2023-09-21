package com.example.springbootcrudmysql.service;

import com.example.springbootcrudmysql.model.Tasks;

import java.util.List;

public interface TaskService {
    Tasks createTask(Tasks dto);
    List<Tasks> retrieveTasks();

    Tasks retrieveTasksById(int id);

    List<Tasks> retrieveTasksByStatus(String status);

    String deleteTask(int id);

    Tasks updateTask(Tasks tasks);
}
