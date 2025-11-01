package com.example.todo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false, length = 200)
	@NotBlank
	@Size(max = 200)
    private String title;
	
	private boolean done = false;
	
	@Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getTitle() { return title; }
	public void setTitle(String todo) { this.title = todo; }
	
	public boolean isDone() { return done; }
	public void setDone(boolean done) { this.done = done; } 
	
	public LocalDateTime getCreatedAt() { return createdAt; }
	public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
	
}
