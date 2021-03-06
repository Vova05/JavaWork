package com.example.service;

import com.example.components.User;
import com.example.repos.UserRepo;
import com.example.service.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
@Transactional
public class userService implements userServiceInterface, UserDetailsService {
    @Autowired
    UserRepo userRepo;

    public userService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public void addUser(User user) {
        if(findUser(user.getLogin()) != null){
            throw new UsernameNotFoundException("Exist");
        }
        userRepo.save(user);
    }

    @Override
    public User findUser(String name) {
        return userRepo.findByLogin(name);
    }

    @Override
    public UserDetails loadUserByUsername(String name) {
        User user = findUser(name);
        if (user == null)
        {
            throw new UsernameNotFoundException("Not found");
        }
        return new UserDTO(user);
    }
}
