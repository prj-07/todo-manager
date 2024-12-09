package com.in28minutes.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class TodoController {

	private TodoService todoservice;
	
	
	public TodoController(TodoService todoservice) {
		super();
		this.todoservice = todoservice;
	}


	@RequestMapping("list-todos")
	public String listall(ModelMap model) {
		List<Todo>todos = todoservice.findbyuser("prj07");
		model.addAttribute("todos", todos);
		return "todo";
	}
	

	@RequestMapping("delete-todo")
	public String deletetodo(@RequestParam int id) {
		todoservice.deletetodo(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value ="update-todo",method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public String showupdatetodo(@RequestParam int id,ModelMap model) {
		Todo todo = todoservice.findbyid(id);
		model.addAttribute("todo", todo);
		return "addtodo";
	}
	
	@RequestMapping(value="update-todo",method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public String updatetodo( ModelMap model,@Valid Todo todo,BindingResult result) {
	//model.put("todo",data);
		if(result.hasErrors()) {
			return "addtodo";
		}
		String username =(String) model.get("name");
		todo.setUsername(username);
		todoservice.updatetodo(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="add-todo",method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public String showalltodo(ModelMap model) {
		String username =(String) model.get("name");
		Todo todo = new Todo(0,username,"",LocalDate.now(),false);
		model.put("todo", todo);
		return "addtodo";
	}

	//first we need to fetch the todo
	//we want this new todo to be added to todo list 
	@RequestMapping(value="add-todo",method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public String addnewtodo( ModelMap model,@Valid Todo todo,BindingResult result) {
	//model.put("todo",data);
		if(result.hasErrors()) {
			return "addtodo";
		}
		String username =(String) model.get("name");
		todoservice.addtodo(username, todo.getdescription(), todo.getDate().plusYears(1), false);
		return "redirect:list-todos";
	}
	
}
