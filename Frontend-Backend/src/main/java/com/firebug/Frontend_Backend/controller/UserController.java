package com.firebug.Frontend_Backend.controller;

import com.firebug.Frontend_Backend.entity.UserEntity;
import com.firebug.Frontend_Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("home")
@CrossOrigin("http://localhost:3002")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<UserEntity> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PostMapping
    public boolean saveUser(@RequestBody UserEntity user){
        userService.saveUser(user);
        return true;
    }
    @PutMapping("{id}")
    public boolean updateUserById(@PathVariable Long id, @RequestBody UserEntity user){
        Optional<UserEntity> existingUser = userService.getUserById(id);
        if (existingUser.isPresent()) {
            UserEntity updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setUsername(user.getUsername());
            updatedUser.setEmail(user.getEmail());
            userService.saveUser(updatedUser);
            return true;
        }
        return false;
    }
    @DeleteMapping("{id}")
    public boolean deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return true;
    }
}
