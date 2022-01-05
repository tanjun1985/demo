package com.example.demo.readinglist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.CompositeName;
import javax.naming.Name;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }
}
