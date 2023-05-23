package com.example.todoapi.todo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

	void deleteTodoByText(String originalText);
	Todo getByText(String originalText);

	@Modifying
	@Query("UPDATE Todo c " +
			"SET c.text = ?2 " +
			"WHERE c.text = ?1")
	int updateText(String originalText, String text);

}
