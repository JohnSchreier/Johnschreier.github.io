package com.example.Schreier_John_PRedictions_CaseStudy.services.impl;

import com.example.Schreier_John_PRedictions_CaseStudy.model.MyUserDetails;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.repository.UserRepository;
import com.example.Schreier_John_PRedictions_CaseStudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bcrypt;


    //method to get user by email
    @Override
    public User getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return user;

    }
    //    method to save to repo and encrypt user password:
    @Override
    public User registerUser(User user) {
//        set if exception
        user.setPassword(bcrypt.encode(user.getPassword()));
        return userRepository.save(user);

    }
//add method
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        System.out.println("User:  "+user);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new MyUserDetails(user);
    }
}