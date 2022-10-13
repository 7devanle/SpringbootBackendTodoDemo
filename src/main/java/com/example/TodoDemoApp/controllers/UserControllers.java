package com.example.TodoDemoApp.controllers;

import com.example.TodoDemoApp.entity.Todos;
import com.example.TodoDemoApp.entity.Users;
import com.example.TodoDemoApp.repository.TodoRepository;
import com.example.TodoDemoApp.repository.UserRepository;
import com.example.TodoDemoApp.request.AddTodoRequest;
import com.example.TodoDemoApp.request.AddUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserControllers {

    private UserRepository userRepo;
    private TodoRepository todoRepo;

    public UserControllers(UserRepository userRepo, TodoRepository todoRepo){
        this.userRepo = userRepo;
        this.todoRepo = todoRepo;
    }

    @GetMapping("/{userId}")
    public void getUserById(@PathVariable Long userId){
        userRepo.findById(userId).orElseThrow(()-> new NoSuchElementException());
//        return new ResponseEntity<>(""+(userRepo.findById(userId).orElseThrow(()-> new NoSuchElementException())).toString(),
//                HttpStatus.ACCEPTED);
    }
    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }
    @GetMapping("/{userID}/todos")
    public List<Todos> getAllTodos(@PathVariable Long userId){
        Users user1 = userRepo.findById(userId).orElseThrow(()-> new NoSuchElementException());
        return user1.getTodosList();
    }

    @PostMapping("/createuser")
    public Users createUser(@RequestBody AddUserRequest userRequest){
        Users user = new Users();
        user.setUsername(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        return userRepo.save(user);
    }

    @PostMapping("/{userId}/addtodo")
    public Users addTodo(@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest){
        Todos todo1 = new Todos();
        todo1.setCompleted(false);
        todo1.setDetails(todoRequest.getContent());
        Users user1 = userRepo.findById(userId).orElseThrow(()-> new NoSuchElementException());
        user1.getTodosList().add(todo1);
        todoRepo.save(todo1);
        return userRepo.save(user1);
//        return new ResponseEntity<>(""+user1.getUsername() +" added a todo",HttpStatus.ACCEPTED);
    }

    @PostMapping("/todos/{todoId}")
    public Todos toggleTodoCompleted(@PathVariable Long todoId){
        Todos todo1 = todoRepo.findById(todoId).orElseThrow(()-> new NoSuchElementException());
        todo1.setCompleted(!(todo1.isCompleted()));
        return todoRepo.save(todo1);
    }

    @DeleteMapping("/{userId}/todos/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable Long userId, @PathVariable Long todoId){
        Users user = userRepo.findById(userId).orElseThrow(()-> new NoSuchElementException());
        Todos todo1 = todoRepo.findById(todoId).orElseThrow(()-> new NoSuchElementException());
        user.getTodosList().remove(todo1);
        todoRepo.delete(todo1);
        return new ResponseEntity<>(""+todo1.getDetails() +" has been deleted",HttpStatus.OK);
    }

    @DeleteMapping("users/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId){
        Users user1 = userRepo.findById(userId).orElseThrow(()-> new NoSuchElementException());
        userRepo.delete(user1);
        return new ResponseEntity<>(""+ user1.getUsername() +" has been deleted",HttpStatus.OK);
    }
}
