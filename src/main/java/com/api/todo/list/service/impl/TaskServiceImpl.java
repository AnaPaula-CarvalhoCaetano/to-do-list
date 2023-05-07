package com.api.todo.list.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.todo.list.DTO.TaskDTO;
import com.api.todo.list.model.Task;
import com.api.todo.list.repository.TaskRepository;
import com.api.todo.list.service.TaskService;

import jakarta.transaction.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	@Override
	public TaskDTO createTask(TaskDTO taskDto) {
	    Task task = modelMapper.map(taskDto, Task.class);
	    taskRepository.save(task);
	    return modelMapper.map(task, TaskDTO.class);
	}

	@Override
	public List<TaskDTO> getTask() {
		List<Task> tasks = (List<Task>) taskRepository.findAll();
		return tasks.stream().map(task -> modelMapper.map(task, TaskDTO.class)).collect(Collectors.toList());
	}

	@Override
	public TaskDTO getTaskById(long id) {
		Task task = taskRepository.findById(id).orElseThrow();
		return modelMapper.map(task, TaskDTO.class);
	}

	@Override
	public TaskDTO updateTask(TaskDTO taskDto, long id) {
		Task task = taskRepository.findById(id).orElseThrow();
		task.setDescricao(taskDto.getDescricao());
		task.setResponsavel(taskDto.getResponsavel());
		task.setDataCriacao(taskDto.getDataCriacao());
		task.setDataConclusao(taskDto.getDataConclusao());
		task.setConcluida(taskDto.isConcluida());

		taskRepository.save(task);

		return modelMapper.map(task, TaskDTO.class);
	}

	@Override
	public void deleteTask(long id) {
		taskRepository.deleteById(id);
	}

}
