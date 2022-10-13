package com.example.TodoDemoApp;

import com.example.TodoDemoApp.entity.Todos;
import com.example.TodoDemoApp.entity.Users;
import com.example.TodoDemoApp.repository.TodoRepository;
import com.example.TodoDemoApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class TodoDemoAppApplication //implements CommandLineRunner{
{

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private TodoRepository todoRepo;

	public static void main(String[] args) {
		SpringApplication.run(TodoDemoAppApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Users user1 = new Users("John vando", "SkyFall2022");
//		Todos todo1 = new Todos("Sharpen the knife");
//
//		user1.getTodosList().add(todo1);
//		todoRepo.save(todo1);
//		userRepo.save(user1);
//
//	}
}
