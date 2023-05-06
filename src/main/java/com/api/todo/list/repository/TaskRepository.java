package com.api.todo.list.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.todo.list.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{

}
