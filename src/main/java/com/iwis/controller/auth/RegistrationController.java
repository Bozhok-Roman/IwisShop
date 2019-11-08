package com.iwis.controller.auth;

import com.iwis.dao.entity.Role;
import com.iwis.dao.entity.User;
import com.iwis.dao.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller

public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration/admin")
    public String registrationAdmin(){
        return "registration_admin";

    }
    @GetMapping("/registration/user")
    public String registrationUser(){
        return "registration_user";

    }
    @PostMapping("/registration/admin")
    public String addAdmin(Model model,User admin){
        User adminUserFromDb = userRepository.findByUsername(admin.getUsername());

        if(adminUserFromDb != null){
            model.addAttribute("message","User exists!");
            return "registration_admin";
        }


        admin.setRoles(Collections.singleton(Role.ADMIN));
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        userRepository.save(admin);
        return "redirect:/login";

    }
    @PostMapping("/registration/user")
    public String addUser(Model model,User user){
        User adminUserFromDb = userRepository.findByUsername(user.getUsername());

        if(adminUserFromDb != null){
            model.addAttribute("message","User exists!");
            return "registration_admin";
        }


        user.setRoles(Collections.singleton(Role.USER));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";

    }
}
