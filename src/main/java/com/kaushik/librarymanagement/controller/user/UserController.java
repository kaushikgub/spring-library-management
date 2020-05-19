package com.kaushik.librarymanagement.controller.user;

import com.kaushik.librarymanagement.entity.BorrowItem;
import com.kaushik.librarymanagement.entity.User;
import com.kaushik.librarymanagement.repository.UserRepository;
import com.kaushik.librarymanagement.service.user.BorrowItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BorrowItemService borrowItemService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String index(Model model, Principal principal){
        Optional<User> user = userRepository.findByUserName(principal.getName());
        user.orElseThrow(()-> new UsernameNotFoundException("Not Found"));
        model.addAttribute("items", borrowItemService.getUserItem(user.get()));
        return "user/index";
    }

    @GetMapping("/test")
    @ResponseBody
    public User users(Principal principal){
        Optional<User> user = userRepository.findByUserName(principal.getName());
        return user.get();
    }
}
