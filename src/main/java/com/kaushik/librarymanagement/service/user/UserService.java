package com.kaushik.librarymanagement.service.user;

import com.kaushik.librarymanagement.entity.User;
import com.kaushik.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveOrUpdate(User user){
        userRepository.save(user);
    }
}
