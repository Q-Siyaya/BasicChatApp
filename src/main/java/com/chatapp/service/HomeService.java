package com.chatapp.service;

import com.chatapp.model.Geek;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class HomeService
{
    public ModelAndView findSinUpPage()
    {
        Geek geek =new Geek();

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("geek", geek);
        modelAndView.setViewName("signup");

        return modelAndView;
    }
}
