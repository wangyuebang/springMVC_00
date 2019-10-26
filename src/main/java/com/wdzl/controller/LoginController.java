package com.wdzl.controller;

import com.wdzl.entity.User;
import com.wdzl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("tologin")
    public String tologin(){
        System.out.println("ss");
        return "login";
    }

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, User user ){
        boolean isValidUser=userService.hasMatch(user.getUsername(),user.getPassword());
        if (isValidUser){
            request.getSession().setAttribute("user",user.getUsername());
            return new ModelAndView("success");
        }else{
            return new ModelAndView("login","error","用户名或密码错误");
        }
    }

}
