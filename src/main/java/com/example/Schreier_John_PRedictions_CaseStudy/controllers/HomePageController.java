package com.example.Schreier_John_PRedictions_CaseStudy.controllers;

import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    UserService userService;


}
