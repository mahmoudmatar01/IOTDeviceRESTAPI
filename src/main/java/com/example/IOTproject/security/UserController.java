package com.example.IOTproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/newUser")
    public void saveUser(@RequestBody AppUser user){
        userService.saveUser(user);
    }
    @GetMapping("/allUsers")
    public List<AppUser> findUsers(){
        return this.userService.findUsers();
    }
}
