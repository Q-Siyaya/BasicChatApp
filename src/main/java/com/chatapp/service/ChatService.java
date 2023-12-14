package com.chatapp.service;

import com.chatapp.model.Geek;
import com.chatapp.repository.GeeksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ChatService {

    @Autowired
    private GeeksRepository geeksRepository;

    public ModelAndView getChatHomePage()
    {
        ModelAndView modelAndView=new ModelAndView();

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        String email=authentication.getName();

        Geek geek=geeksRepository.findByEmail(email);

        modelAndView.addObject("geek",geek);

        modelAndView.setViewName("home_chat");

        return modelAndView;
    }
}
