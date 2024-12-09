package com.in28minutes.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    
    private static int cnt = 0 ;

    static {
        todos.add(new Todo(++cnt, "prj07", "learn spring", LocalDate.now().plusMonths(1), false));
        todos.add(new Todo(++cnt, "prj07", "learn react", LocalDate.now().plusMonths(2), false));
        todos.add(new Todo(++cnt, "prj07", "learn Devops", LocalDate.now().plusMonths(1), false));
    	cnt++;
    }

	public List<Todo> findbyuser(String username){
		return todos;
	}

	public void addtodo(String username,String Descr,LocalDate target,boolean done) {
		Todo todo = new Todo(cnt, username, Descr, LocalDate.now().plusMonths(6), done);
		todos.add(todo);
		++cnt;
	}
	
	public void deletetodo(int id) {
		Predicate<? super Todo>predicate = todo ->todo.getId() ==id;
	
		todos.removeIf(predicate);
		
	}

	public Todo findbyid(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo>predicate = todo ->todo.getId() ==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updatetodo(Todo todo) {
		// TODO Auto-generated method stub
		deletetodo(todo.getId());
		todos.add(todo);
		
	}
}
