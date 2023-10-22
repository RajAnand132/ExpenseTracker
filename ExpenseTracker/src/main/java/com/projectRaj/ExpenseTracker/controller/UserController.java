package com.projectRaj.ExpenseTracker.controller;

import com.projectRaj.ExpenseTracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public String registerUser(@RequestParam String userName , @Valid  @RequestParam String password) {
        // Handle user registration and return the registered user
        return userService.registerUser(userName,password);
    }

    @PostMapping("/signIn")
    public String loginUser(@RequestParam String userName , @RequestParam String password) {
        // Handle user login and return the authenticated user
        return userService.loginUser(userName, password);
    }

    @PostMapping("/signOut")
    public String logOffUser(@RequestParam String userName) {
        // Handle user signout and make user log off
        return userService.logOffUser(userName);
    }
}
