package com.tekup.sdia_en.controller;


import com.tekup.sdia_en.entity.UserProfile;
import com.tekup.sdia_en.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userProfile")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping("/create/{userId}")
    public UserProfile createProfile(@PathVariable Long userId , @RequestBody UserProfile userProfile){
        return userProfileService.saveProfile(userId , userProfile);
    }

    @GetMapping("/get/{userId}")
    public UserProfile getProfileByUser(@PathVariable Long userId){
        return userProfileService.getProfileForUser(userId);
    }

    @PatchMapping("/update/{id}")
    public UserProfile update(@PathVariable Long id , @RequestBody UserProfile updatedProfile){
        return userProfileService.updateProfile(id , updatedProfile);
    }
}
