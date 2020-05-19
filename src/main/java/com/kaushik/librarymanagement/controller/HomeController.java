package com.kaushik.librarymanagement.controller;

import com.kaushik.librarymanagement.entity.User;
import com.kaushik.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public String home(){
        return "index";
    }

    @GetMapping("/success")
    public String successRedirect(Principal principal){
        Optional<User> user = userRepository.findByUserName(principal.getName());
        user.orElseThrow(()-> new UsernameNotFoundException("Not Found"));
        if (user.get().getType().equals("user")){
            return "redirect:/user";
        } else if (user.get().getType().equals("admin")){
            return "redirect:/admin/book";
        }
        return null;
    }
}
