package com.sandra.service.task;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    public Task findByIdAndUserId(Integer id, Integer userId);
    public List<Task> findByUserId(Integer userId);

}
