package com.example.demo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")

public class Task {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Task name is required")
	    private String name;

	    @NotBlank(message = "Description is required")
	    private String description;

	    @NotBlank(message = "AssignedTo is required")
	    private String assignedTo;

	    @NotBlank(message = "Due date is required")
	    private String dueDate;

	    @NotBlank(message = "Status is required")
	    private String status;

	    // Getters and Setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getAssignedTo() {
	        return assignedTo;
	    }

	    public void setAssignedTo(String assignedTo) {
	        this.assignedTo = assignedTo;
	    }

	    public String getDueDate() {
	        return dueDate;
	    }

	    public void setDueDate(String dueDate) {
	        this.dueDate = dueDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
}
