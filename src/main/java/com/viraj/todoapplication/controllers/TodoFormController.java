package com.viraj.todoapplication.controllers;

import com.viraj.todoapplication.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoFormController {

    @Autowired
    TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreateForm(){
        return "new-todo-item";
    }
}