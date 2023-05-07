package com.api.todo.list.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.todo.list.DTO.TaskDTO;
import com.api.todo.list.model.Task;

@Service
public interface TaskService {

	public TaskDTO createTask(TaskDTO task);

	public List<TaskDTO> getTask();

	public TaskDTO getTaskById(long id);

	public TaskDTO updateTask(TaskDTO task, long id);

	public void deleteTask(long id);

	
}
