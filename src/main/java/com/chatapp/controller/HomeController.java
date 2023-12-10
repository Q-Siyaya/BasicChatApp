package com.chatapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"","/home","/"})
    public String findHomePage()
    {
        return "home.html";
    }
}
