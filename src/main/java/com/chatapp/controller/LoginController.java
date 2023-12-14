package com.chatapp.controller;


import com.chatapp.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})

    public String login(
            @RequestParam(value = "register",required = false) String register
    , @RequestParam(value = "error",required = false)String error
    , @RequestParam(value = "logout",required = false)String logout, Model model)
    {

        loginService.setLoginMsg( register,  error, logout,model);
        return "home.html";
    }


    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response)
    {


        loginService.logOutGeek(request,response);
        return "redirect:/login?logout=true";
    }

}
