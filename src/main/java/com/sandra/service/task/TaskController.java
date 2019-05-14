package com.sandra.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {



    @Autowired
    private TaskRepository repository;

    @RequestMapping("/")
    public @ResponseBody String usage() {
        return "Provides Following CRUD Operations for Tasks";
    }

    @GetMapping(path = "/admin/tasks")
    public @ResponseBody Iterable<Task> getAllTasks() {
        return repository.findAll();
    }

    @PostMapping(path = "/users/tasks")
    public @ResponseBody Task createTask(
            @RequestParam("userId") Integer userId,
            @RequestBody TaskDTO taskDto){
        Task task0 = new Task();
        Task task= mappingTask(task0, taskDto);
        if(!JSONValidator.validator(task)){
            throw new NotAcceptableJSON();
        }
        task.setUserId(userId);
        return  repository.save(task);
    }

    @GetMapping(path = "/users/tasks")
    public @ResponseBody List<Task> getTasksForUser( @RequestParam("userId") Integer userId){
       List<Task> tasks=  repository.findByUserId(userId);
       if(tasks.isEmpty()){
           throw new UserNotFoundException();
       }
       return tasks;
    }

    @GetMapping(path = "/users/tasks/{taskId}")
    public @ResponseBody Task getTaskForUser(@PathVariable Integer taskId,  @RequestParam("userId") Integer userId){

        Task t= repository.findByIdAndUserId(taskId,userId );
        if(t==null){
            throw new TaskNotFoundException();
        }
        return t;
    }

    @DeleteMapping(path = "/users/tasks/{taskId}")
    public @ResponseBody Task deleteTaskForUser(@PathVariable Integer taskId,  @RequestParam("userId") Integer userId){
        Task t= repository.findByIdAndUserId(taskId,userId );
        if(t==null){
            throw new TaskNotFoundException();
        }
        repository.delete(t);
        return t;
    }

    @PutMapping(path = "/users/tasks/{taskId}")
    public Task updateTaskForUser(@PathVariable Integer taskId,
                                  @RequestParam("userId") Integer userId,
                                  @RequestBody TaskDTO taskDto){
        Task task= repository.findByIdAndUserId(taskId,userId );
        if(task==null){
            throw new TaskNotFoundException();
        }

       Task task2=mappingTask(task, taskDto);
        if(!JSONValidator.validator(task2)){
            throw new NotAcceptableJSON();
        }
        repository.save(task2);
        return task2;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Task or user not found")
    public  class TaskNotFoundException extends RuntimeException{
    }
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found")
    public  class UserNotFoundException extends RuntimeException{
    }
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Json not acceptable")
    public  class NotAcceptableJSON extends RuntimeException{
    }

    @ResponseStatus(value = HttpStatus.CREATED, reason = "Successful Creation")
    public class ObjectCreated{

    }

    public static Task mappingTask(Task task, TaskDTO taskDto){
        if(task== null){
            task= new Task(); }
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setReminder(taskDto.getReminder());
        task.setTitle(taskDto.getTitle());
        task.setDone(taskDto.getDone());
        task.setCompletionDate(taskDto.getCompletionDate());
        return task;
    }






}
