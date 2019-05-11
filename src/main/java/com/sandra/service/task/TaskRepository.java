package com.sandra.service.task;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    public Task findByIdAndUserId(Integer id, Integer userId);


}
