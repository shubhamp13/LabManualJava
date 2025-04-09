package com.question25;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController
{
    @GetMapping("/home")
    public String home()
    {
        return "index";
    }

   @PostMapping("/greet")
    public String greet(@RequestParam("name")String name, Model model)
    {
        model.addAttribute("name", name);
        return "greet";
    }
}
