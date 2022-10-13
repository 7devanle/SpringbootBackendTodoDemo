package com.example.TodoDemoApp.request;

public class AddTodoRequest {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AddTodoRequest(String content) {
        this.content = content;
    }

    public AddTodoRequest() {
    }
}
