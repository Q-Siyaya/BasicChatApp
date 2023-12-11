package com.chatapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = {"","/home","/"})
    public String findHomePage()
    {
        return "home.html";
    }

    @GetMapping("/getSignUpPage")
    public ModelAndView getSignUpPage()
    {
        return new ModelAndView("signup");
    }
}
