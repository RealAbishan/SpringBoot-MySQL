package com.example.springbootcrudmysql.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.example.springbootcrudmysql.model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootcrudmysql.repository.TaskRepository;
import com.example.springbootcrudmysql.service.TaskService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Tasks createTask(Tasks dto) {
        return taskRepository.save(dto);
    }

    @Override
    public List<Tasks> retrieveTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Tasks retrieveTasksById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tasks> retrieveTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public String deleteTask(int id) {
        taskRepository.deleteById(id);
        return "Task Deleted with " +  " " +id;    }

    @Override
    @Transactional
    public Tasks updateTask(Tasks tasks) {
        taskRepository
                .findById(tasks.getTaskId()) // returns Optional<User>
                .ifPresent(updatedTask -> {
                    updatedTask.setTask(tasks.getTask());
                    updatedTask.setDescription(tasks.getDescription());
                    updatedTask.setAssign(tasks.getAssign());
                    updatedTask.setStatus(tasks.getStatus());

                    taskRepository.save(updatedTask);
                });


//        Optional<Tasks> existingTask = taskRepository.findById(tasks.getTaskId());
//        Tasks updatedTask = existingTask.get();
//        updatedTask.setTask(tasks.getTask());
//        updatedTask.setDescription(tasks.getDescription());
//        updatedTask.setAssign(tasks.getAssign());
//        updatedTask.setStatus(tasks.getStatus());
//        return taskRepository.save(updatedTask);
        return tasks;
    }

}
