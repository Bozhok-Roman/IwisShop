package com.iwis.controller.auth;

import com.iwis.dao.entity.Role;
import com.iwis.dao.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class LoginController {



    @GetMapping("/login")
    public String login (){
        return "login";
    }

    @PostMapping("/login")
    public String userLogin(User user){

        if (user.getRoles().equals(Collections.singleton(Role.ADMIN))){
            return "redirect:/admin/admin_page";
        }
        return "redirect:/user/user_page";

    }
}
