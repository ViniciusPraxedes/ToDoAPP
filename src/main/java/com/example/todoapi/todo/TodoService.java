package com.example.todoapi.todo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;

	public List<Todo> getAll(){
		return todoRepository.findAll();
	}
	public String createTodo(String text) {
		Todo todo = new Todo(text, false);
		todoRepository.save(todo);
		return "Success";
	}
	@Transactional
	public String deleteByText(String originalText) {
		todoRepository.deleteTodoByText(originalText);
		return "Success";
	}

	public Todo getById(String originalText){
		return todoRepository.getByText(originalText);
	}
	@Transactional
	public String updateTodo(String originalText, String text) {
		todoRepository.updateText(originalText,text);
		return "Success";
	}
}