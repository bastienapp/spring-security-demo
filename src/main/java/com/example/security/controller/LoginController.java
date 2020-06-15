package com.example.security.controller;

import com.example.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class LoginController {

    @Autowired
    private SecurityService securityService;

    @RolesAllowed("USER")
    @GetMapping("/")
    public String getUser() {
        String username = securityService.findLoggedInUsername();
        return "Welcome " + username;
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/admin")
    public String getAdmin() {
        return "Welcome Admin";
    }
}
