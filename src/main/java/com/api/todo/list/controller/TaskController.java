package com.api.todo.list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.todo.list.DTO.TaskDTO;
import com.api.todo.list.service.impl.TaskServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskServiceImpl taskService;

	@PostMapping
	public TaskDTO createTask(@RequestBody TaskDTO taskDto) {
		return taskService.createTask(taskDto);
	}

	@GetMapping
	public List<TaskDTO> getTasks() {
		return taskService.getTask();
	}

	@GetMapping("/{id}")
	public TaskDTO getTaskById(@PathVariable("id") long id) {
		return taskService.getTaskById(id);
	}

	@PutMapping("/{id}")
	public TaskDTO updateTask(@RequestBody TaskDTO taskDto, @PathVariable("id") long id) {
		return taskService.updateTask(taskDto, id);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable("id") long id) {
		taskService.deleteTask(id);
	}
}
