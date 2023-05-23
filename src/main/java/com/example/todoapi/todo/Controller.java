package com.example.todoapi.todo;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class Controller {
	@Autowired
	private TodoService todoService;


	@GetMapping("/todos")
	public List<Todo> getAllTodos() {
		return todoService.getAll();
	}

	@GetMapping("/todos/{originalText}")
	public Todo getTodo(@PathVariable String originalText) {
		return todoService.getById(originalText);
	}

	@DeleteMapping("/todos/{originalText}")
	public void deleteTodo(@PathVariable String originalText) {
		todoService.deleteByText(originalText);
	}
	@PutMapping("todos/{originalText}")
	public void updateTodo(@PathVariable String originalText, @RequestBody Todo todo) {
		System.out.println(originalText);
		System.out.println(todo.getText());
		todoService.updateTodo(originalText,todo.getText());
	}
	@PostMapping("/todos")
	public void createTodo(@RequestBody Todo todo) {
		todoService.createTodo(todo.getText());
	}

}
