package com.example.TodoDemoApp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Todos> todosList;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
        this.todosList = new ArrayList<>();
    }

    public Users(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Todos> getTodosList() {
        return todosList;
    }

    public void setTodosList(List<Todos> todosList) {
        this.todosList = todosList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
