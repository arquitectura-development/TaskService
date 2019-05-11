package com.sandra.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import java.lang.annotation.ElementType;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @RequestMapping("/")
    public @ResponseBody String usage() {
        return "Provides Following CRUD Operations...";
    }

    @GetMapping(path = "/tasks")
    public @ResponseBody Iterable<Task> getAllTasks() {
        //ADMIN endpoint to get all tasks
        return repository.findAll();
    }

    @PostMapping(path = "/tasks/user")
    public @ResponseBody Task createTask(
            @RequestHeader("userId") Integer userId,
            @RequestBody Task task){
        task.setUserId(userId);
        return  repository.save(task);
    }

    @GetMapping(path = "/tasks/user")
    public String getTasksForUser( @RequestHeader("userId") Integer userId){
        //Task t= repository.findByUser(userId);

        return "Get all tasks for an user";
    }

    @GetMapping(path = "/tasks/user/{taskId}")
    public @ResponseBody Task getTaskForUser(@PathVariable Integer taskId,  @RequestHeader("userId") Integer userId){

        Task t= repository.findByIdAndUserId(taskId,userId );
        if(t==null){
            throw new TaskNotFoundException();
        }
               // "Get specific user task {"+taskId+"}";
        return t;
    }

    @DeleteMapping(path = "/tasks/user/{taskId}")
    public String deleteTaskForUser(@PathVariable Integer taskId){
        return "Delete specific user task {"+taskId+"}";
    }

    @PutMapping(path = "/tasks/user/{taskId}")
    public String updateTaskForUser(@PathVariable Integer taskId){

        return "Updates specific user task {"+taskId+"}";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Task or user not found")
    public  class TaskNotFoundException extends RuntimeException{
    }

}
