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
    public @ResponseBody List<Task> getTasksForUser( @RequestHeader("userId") Integer userId){
        //Task t= repository.findByUser(userId);
       List<Task> tasks=  repository.findByUserId(userId);
       if(tasks.isEmpty()){
           throw new UserNotFoundException();
       }
       return tasks;
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
    public @ResponseBody Task deleteTaskForUser(@PathVariable Integer taskId,  @RequestHeader("userId") Integer userId){
        Task t= repository.findByIdAndUserId(taskId,userId );
        if(t==null){
            throw new TaskNotFoundException();
        }
        repository.delete(t);
        return t;
    }

    @PutMapping(path = "/tasks/user/{taskId}")
    public Task updateTaskForUser(@PathVariable Integer taskId,
                                  @RequestHeader("userId") Integer userId,
                                  @RequestBody Task task){
        Task t= repository.findByIdAndUserId(taskId,userId );

        if(t==null){
            throw new TaskNotFoundException();
        }
        t.setId(taskId);
        t.setDescription(task.getDescription());
        t.setDifficulty(task.getDifficulty());
        t.setDueDate(task.getDueDate());
        t.setReminder(task.getReminder());
        t.setTitle(task.getTitle());
        repository.save(t);
        return t;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Task or user not found")
    public  class TaskNotFoundException extends RuntimeException{
    }
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found")
    public  class UserNotFoundException extends RuntimeException{
    }

}
