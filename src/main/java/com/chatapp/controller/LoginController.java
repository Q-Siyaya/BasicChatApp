package com.chatapp.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController
{
    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})

    public String login(
            @RequestParam(value = "register") String register
    , @RequestParam(value = "error")String error
    , @RequestParam(value = "logout")String logout, Model model)
    {
        String errMsg=null;

        if(error !=null)
        {
            errMsg="Username or Password is incorrect !!";
        }
        if(logout !=null)
        {
            errMsg="You have been successfully logged out !!";
        }
        if(register !=null)
        {
            errMsg="You registration successful. Login with registered credentials !!";
        }

        model.addAttribute("errMsg",errMsg);
        return "home.html";
    }


    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response)
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication !=null)
        {
             new SecurityContextLogoutHandler().logout(request,response,authentication);
        }

        return "redirect:/login?logout=true";
    }

}
