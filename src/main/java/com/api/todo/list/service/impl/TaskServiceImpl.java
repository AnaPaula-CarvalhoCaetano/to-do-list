package com.api.todo.list.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.todo.list.model.Task;
import com.api.todo.list.repository.TaskRepository;
import com.api.todo.list.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task createTaks(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getTask() {
		return (List<Task>) taskRepository.findAll();
	}

	@Override
	public Task getTaskById(long id) {
		return taskRepository.findById(id).get();
	}

	@Override
	public Task updateTask(Task task, long id) {
		Task task1 = taskRepository.findById(id).get();
		task1.setDescricao(task.getDescricao());
		task1.setResponsavel(task.getResponsavel());
		task1.setDataCriacao(task.getDataCriacao());
		task1.setDataConclusao(task.getDataConclusao());
		task1.setConcluida(true);

		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(long id) {
		taskRepository.deleteById(id);
	}

}
