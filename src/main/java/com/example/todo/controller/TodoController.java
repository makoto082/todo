package com.example.todo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;

@RestController
@RequestMapping("api/todos")
public class TodoController {
	
	/** DI */
	private final TodoRepository repo;
	public TodoController(TodoRepository repo) { this.repo = repo; }
	
	@GetMapping
	public List<Todo> findAll() {
		return repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}
	
	@PostMapping
	public Todo create(@RequestBody Map<String, String> body) {
		String title = body.getOrDefault("title", "").trim();
		if (title.isEmpty()) throw new IllegalArgumentException("title is required");
		Todo t = new Todo();
		t.setTitle(title);
		return repo.save(t);
	}
	
	@PatchMapping
	public Todo done(@PathVariable Long id) {
		Todo t = repo.findById(id).orElseThrow();
		t.setDone(true);
		return repo.save(t);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}
	
}
