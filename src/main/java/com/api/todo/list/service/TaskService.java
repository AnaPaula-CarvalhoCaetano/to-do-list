package com.api.todo.list.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.todo.list.model.Task;

@Service
public interface TaskService {

	public Task createTaks(Task task);

	public List<Task> getTask();

	public Task getTaskById(long id);

	public Task updateTask(Task task, long id);

	public void deleteTask(long id);
}
