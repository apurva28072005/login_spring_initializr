package com.example.App.controller;

import com.example.App.dao.UserDAO;
import com.example.App.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @GetMapping("/run")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String password,
                           Model model) {

        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);

        boolean success = UserDAO.register(u);

        if(success){
            return "redirect:/run";
        } else {
            model.addAttribute("error", "Email already exists or DB error.");
            return "register";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        User user = UserDAO.login(email, password);

        if (user != null) {
            session.setAttribute("user", user);
            return "welcome";
        } else {
            model.addAttribute("error", "Invalid Credentials");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/run";
    }
}
