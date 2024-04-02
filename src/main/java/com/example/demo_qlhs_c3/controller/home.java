package com.example.demo_qlhs_c3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class home {
    @GetMapping
    public String home(){
        return "index";

    }
}
