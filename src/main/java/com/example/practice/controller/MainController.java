package com.example.practice.controller;

import com.example.practice.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MainController {
    @GetMapping(value = {"/", "/index"})
    public String index() { return "index"; }
    @GetMapping("/admin")
    public String admin() {return "admin";}
    @GetMapping("/user")
    public String user() {return "user";}
    @GetMapping("/login")
    public String login() {return "login";}
}
