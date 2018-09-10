package de.maeddes.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/todos")
public class TodolistApplication {

	ArrayList<String> todos = new ArrayList<>();

	@GetMapping
	public List<String> getTodos(){

		return todos;

	}

	@PostMapping("{todo}")
	public String add(@PathVariable String todo){

		todos.add(todo);
		return "added "+todo;

	}

	@DeleteMapping("{todo}")
	public String remove(@PathVariable String todo){

		todos.remove(todo);
		return "removed "+todo;

	}


	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}
}
