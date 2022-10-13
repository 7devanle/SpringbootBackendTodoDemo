package com.example.TodoDemoApp.request;

public class AddUserRequest {
    private String userName;
    private String password;

    public AddUserRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public AddUserRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
