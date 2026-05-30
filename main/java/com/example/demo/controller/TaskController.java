package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")

@CrossOrigin(origins = "*")

public class TaskController {
	@Autowired
    private TaskService service;

    // GET ALL TASKS
    @GetMapping
    public List<Task> getTasks() {

        return service.getAllTasks();
    }

    // ADD TASK
    @PostMapping
    public ResponseEntity<Task> addTask(
            @Valid @RequestBody Task task) {

        return ResponseEntity.ok(
                service.addTask(task)
        );
    }

    // UPDATE TASK
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody Task task) {

        Task updated = service.updateTask(id, task);

        if(updated != null){

            return ResponseEntity.ok(updated);
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.deleteTask(id)
        );
    }
}
