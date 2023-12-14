package com.chatapp.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class LoginService {

    public void setLoginMsg(String register, String error, String logout, Model model)
    {

        String errMsg=null;

        if(error !=null)
        {
            errMsg="Username or Password is incorrect !!";
        }
        else if(logout !=null)
        {
            errMsg="You have been successfully logged out !!";
        }
        else if(register !=null)
        {
            errMsg="You registration successful. Login with registered credentials !!";
        }

        model.addAttribute("errMsg",errMsg);

    }


    public void logOutGeek(HttpServletRequest request, HttpServletResponse response)
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication !=null)
        {
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
    }
}
