package com.chatapp.controller;

import com.chatapp.model.Geek;
import com.chatapp.repository.GeeksRepository;
import com.chatapp.service.PublicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublicController
{
    @Autowired
    private GeeksRepository geeksRepository;

    @Autowired
    private PublicService publicService;


    @PostMapping(value = "/createGeek")
    public String createGeek(@Valid @ModelAttribute(name = "geek")Geek geek, Errors errors)
    {
        if(errors !=null)
        {
            return "signup.html";
        }

        boolean isSaved= publicService.createGeek(geek);

        if(isSaved)
        {
            return "redirect:/home";
        }

        return " ";
    }
}
