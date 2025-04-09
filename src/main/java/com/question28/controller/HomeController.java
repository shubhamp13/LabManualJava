package com.question28.controller;

import com.question28.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private WelcomeService welcomeService;

    @RequestMapping("/welcome")
    public String showWelcomePage(Model model) {
        String msg = welcomeService.getWelcomeMessage();
        model.addAttribute("msg", msg);
        return "welcome";
    }
}
