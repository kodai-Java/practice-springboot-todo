
package com.kodai.practice_springboot_todo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class TodoController {

    private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
    @GetMapping
    public String getTodoList() {
        return "todo";
    }

    @GetMapping("/{id}")
    public String getTodo(@PathVariable("id") int id) {
        return "todo/" + id;
    }

    @PostMapping
    public String createTodo() {
        return "created";
    }

    @PutMapping
    public String updateTodo() {
        return "updated";
    }

    @DeleteMapping
    public String deleteTodo() {
        return "deleted";
    }
}