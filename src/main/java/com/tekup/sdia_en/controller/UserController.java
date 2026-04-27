package com.tekup.sdia_en.controller;


import com.tekup.sdia_en.entity.User;
import com.tekup.sdia_en.entity.UserProfile;
import com.tekup.sdia_en.service.UserProfileService;
import com.tekup.sdia_en.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    private final UserProfileService userProfileService;

    public UserController(UserService userService, UserProfileService userProfileService) {
        this.userService = userService;
        this.userProfileService = userProfileService;
    }

    @PostMapping("/users/create")
    public User create(@RequestBody @Valid User user ){
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable Long id){
        return this.userService.getById(id);
    }

    @GetMapping("/users-profile/{id}")
    public UserProfile getByUSer(@PathVariable Long id){
        return userProfileService.getProfileByUser(id);
    }
}
