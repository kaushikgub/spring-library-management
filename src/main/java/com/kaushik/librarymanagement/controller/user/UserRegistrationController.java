package com.kaushik.librarymanagement.controller.user;

import com.kaushik.librarymanagement.entity.User;
import com.kaushik.librarymanagement.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class UserRegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "user/registration";
    }

    @PostMapping("/registration")
    @ResponseBody
    public String registration(@Valid User user){
        user.setRoles("USER");
        user.setType("user");
        user.setCreatedAt(new Date());
        user.setActive(true);
        userService.saveOrUpdate(user);
        return "Saved Successfully";
    }
}
