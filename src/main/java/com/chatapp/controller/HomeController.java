package com.chatapp.controller;


import com.chatapp.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(value = {"","/home","/"})
    public String findHomePage()
    {
        return "home.html";
    }

    @GetMapping("/getSignUpPage")
    public ModelAndView getSignUpPage()
    {
        return homeService.findSinUpPage();
    }
}
