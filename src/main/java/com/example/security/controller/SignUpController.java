package com.example.security.controller;

import com.example.security.entity.User;
import com.example.security.repository.RoleRepository;
import com.example.security.repository.UserRepository;
import com.example.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/signup")
    public String getSignUp(Model out) {
        out.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignUp(@ModelAttribute User user) {
        user.getRoles().add(roleRepository.findByName("ROLE_USER"));
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

        securityService.autoLogin(user.getUsername(), password);

        return "redirect:/";
    }
}
