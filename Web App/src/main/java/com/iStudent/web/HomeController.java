package com.iStudent.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/users/login")
    public String home(){
        return "index";
    }
}
