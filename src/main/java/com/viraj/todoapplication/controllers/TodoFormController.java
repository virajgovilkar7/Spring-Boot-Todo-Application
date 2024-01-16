package com.viraj.todoapplication.controllers;

import com.viraj.todoapplication.models.TodoItem;
import com.viraj.todoapplication.services.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoFormController {

    @Autowired
    TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem){
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {

        if(result.hasErrors()){
            return "new-todo-item";
        }

        TodoItem item = new TodoItem();
        item.setDescription(todoItem.getDescription());

        if(item.getIsComplete() == null){
            item.setIsComplete(false);
        }
        else{
            item.setIsComplete(todoItem.getIsComplete());
        }

        todoItemService.save(item);
        return "redirect:/";
    }
}
