package de.maeddes.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/todos")
public class TodolistApplication {

	@Autowired
	TodoRepository todoRepository;

	@GetMapping
	public List<String> getTodos(){

		List<String> todos = new ArrayList<String>();

		//for(Todo todo : todoRepository.findAll()) todos.add(todo.getTodo());
		todoRepository.findAll().forEach(item->todos.add(item.getTodo()));

		return todos;

	}

	@PostMapping("{todo}")
	public String add(@PathVariable String todo){

		todoRepository.save(new Todo(todo));
		return "added "+todo;

	}

	@DeleteMapping("{todo}")
	public String remove(@PathVariable String todo){

		todoRepository.deleteById(todo);
		return "removed "+todo;

	}


	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}
}


@Entity
class Todo{

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public Todo(String todo) {
		this.todo = todo;
	}

	public Todo() {
	}

	@Id
	String todo;

}


interface TodoRepository extends CrudRepository<Todo,String>{

}
