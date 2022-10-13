package com.example.TodoDemoApp.repository;

import com.example.TodoDemoApp.entity.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todos, Long> {

}
