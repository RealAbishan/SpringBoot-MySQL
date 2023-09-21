package com.example.springbootcrudmysql.controller;

import com.example.springbootcrudmysql.model.Tasks;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springbootcrudmysql.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@Slf4j
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/createTasks")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createTAsk(@RequestBody Tasks taskDto){
        taskService.createTask(taskDto);
        return ResponseEntity.ok("Task Created Successfully");
    }

    @GetMapping("/retrieveTasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Tasks> retrieveTasks() {
        return taskService.retrieveTasks();
    }

    @GetMapping("/retrieveTasksById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tasks retrieveTasksById(@PathVariable int id) {
        return taskService.retrieveTasksById(id);
    }

    @GetMapping("/retrieveTasksByStatus/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tasks> retrieveTasksByStatus(@PathVariable String status){
        return taskService.retrieveTasksByStatus(status);
    }

    @DeleteMapping("/deleteTask/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTask(@PathVariable int id) {
        return taskService.deleteTask(id);
    }

    @PutMapping("/updateTask")
    @ResponseStatus(HttpStatus.OK)
    public Tasks updateTask(@RequestBody Tasks tasks) {
        return taskService.updateTask(tasks);
    }
}
