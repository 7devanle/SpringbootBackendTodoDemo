package com.example.TodoDemoApp.repository;

import com.example.TodoDemoApp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
