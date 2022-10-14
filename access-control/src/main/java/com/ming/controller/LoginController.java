package com.ming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("login","login");
        return "login";
    }

    @RequestMapping("/login1")
    public String login1(){
        return "login";
    }

}
