package com.chatapp.controller;

import com.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatPageController {

    @Autowired
    private ChatService chatService;

    @GetMapping(value = "/getChatPage")
    public ModelAndView getChatPage()
    {
        return chatService.getChatHomePage();
    }
}
