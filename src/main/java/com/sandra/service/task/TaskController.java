package com.sandra.service.task;

import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    private final TaskRepository repository;
    TaskController(TaskRepository repository) {
        this.repository = repository;
    }


    @RequestMapping("/")
    public String usage() {
        return "Provides Following CRUD Operations...";
    }

    @GetMapping(path = "/tasks")
    public String getAllTasks() {
        return "ADMIN endpoint to get all tasks";
    }

    @PostMapping(path = "/tasks/user")
    public String createTask(@RequestBody Task newTask){
        repository.save(newTask);
        return "Create task for given user";
    }

    @GetMapping(path = "/tasks/user")
    public String getTasksForUser(){
        return "Get all tasks for an user";
    }

    @GetMapping(path = "/tasks/user/{taskId}")
    public String getTaskForUser(@PathVariable Integer taskId){
        return "Get specific user task {"+taskId+"}";
    }

    @DeleteMapping(path = "/tasks/user/{taskId}")
    public String deleteTaskForUser(@PathVariable Integer taskId){
        return "Delete specific user task {"+taskId+"}";
    }

    @PutMapping(path = "/tasks/user/{taskId}")
    public String updateTaskForUser(@PathVariable Integer taskId){
        return "Updates specific user task {"+taskId+"}";
    }

}
