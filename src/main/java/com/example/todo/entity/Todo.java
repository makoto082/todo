package com.example.todo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "todo", nullable = false, length = 50)
    private String todo;
	
	@Column(nullable = false)
    private LocalDateTime createdAt;
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getTodo() { return todo; }
	public void setTodo(String todo) { this.todo = todo; }
	
	public LocalDateTime getCreatedAt() { return createdAt; }
	public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
	
}
