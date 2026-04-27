package com.tekup.sdia_en.service;

import com.tekup.sdia_en.entity.User;
import com.tekup.sdia_en.entity.UserProfile;
import com.tekup.sdia_en.exception.RessourceNotFoundException;
import com.tekup.sdia_en.repository.UserProfileRepository;
import com.tekup.sdia_en.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;
    public UserProfileService(UserProfileRepository userProfileRepository, UserRepository userRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
    }

    public UserProfile getProfileByUser(Long userId){

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            return userProfileRepository.findByUser(userOptional.get());
        }else{
            throw new RessourceNotFoundException("User With given ID " + userId + " Not found");
        }
    }
}
