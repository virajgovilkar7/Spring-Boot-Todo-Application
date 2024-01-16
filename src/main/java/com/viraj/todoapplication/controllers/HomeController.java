package com.viraj.todoapplication.controllers;

import com.viraj.todoapplication.models.TodoItem;
import com.viraj.todoapplication.repositories.TodoItemRepository;
import com.viraj.todoapplication.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    TodoItemService todoItemService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;
    }
}
