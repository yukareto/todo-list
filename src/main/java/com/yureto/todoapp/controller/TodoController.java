package com.yureto.todoapp.controller;


import com.yureto.todoapp.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

    private final List<Todo> todoList = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoList);
        return "index";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "form";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo) {
        todoList.add(todo);
        return "redirect:/";
    }
}
