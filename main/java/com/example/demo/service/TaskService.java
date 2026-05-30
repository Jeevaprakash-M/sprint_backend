package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Service

public class TaskService {

	@Autowired
    private TaskRepository repository;

    // Get All Tasks
    public List<Task> getAllTasks() {

        return repository.findAll();
    }

    // Add Task
    public Task addTask(Task task) {

        return repository.save(task);
    }

    // Update Task
    public Task updateTask(Long id, Task updatedTask) {

        Task task = repository.findById(id).orElse(null);

        if(task != null){

            task.setName(updatedTask.getName());
            task.setDescription(updatedTask.getDescription());
            task.setAssignedTo(updatedTask.getAssignedTo());
            task.setDueDate(updatedTask.getDueDate());
            task.setStatus(updatedTask.getStatus());

            return repository.save(task);
        }

        return null;
    }

    // Delete Task
    public String deleteTask(Long id) {

        repository.deleteById(id);

        return "Task Deleted Successfully";
    }
}
