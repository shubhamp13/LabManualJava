package com.question28.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    public String getWelcomeMessage() {
        return "Welcome to Spring MVC  !";
    }
}
