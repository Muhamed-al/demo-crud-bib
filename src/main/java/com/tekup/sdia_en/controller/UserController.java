package com.tekup.sdia_en.controller;


import com.tekup.sdia_en.entity.User;
import com.tekup.sdia_en.service.UserProfileService;
import com.tekup.sdia_en.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserProfileService userProfileService;

    public UserController(UserService userService, UserProfileService userProfileService) {
        this.userService = userService;
        this.userProfileService = userProfileService;
    }

    @PostMapping("/create")
    public User create(@RequestBody @Valid User user ){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUSer(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id , @RequestBody User user){
        return userService.update(id , user);
    }
}
