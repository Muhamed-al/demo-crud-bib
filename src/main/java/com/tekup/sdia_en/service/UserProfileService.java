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

    public UserProfile saveProfile(Long userId , UserProfile userProfile){
        if (!userRepository.existsById(userId)){
            throw new RessourceNotFoundException("User with given id not found");
        }
        UserProfile userProfile1 = userProfileRepository.save(userProfile);

        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.get();
        user.setUserProfile(userProfile1);
        userRepository.save(user);

        return userProfile1;
    }

    public UserProfile getProfileForUser(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()){
            throw new RessourceNotFoundException("User with given not found");
        }
        User user = userOptional.get();
        return userProfileRepository.findByUser(user);
    }


    public UserProfile updateProfile(Long id , UserProfile updatedUserProfile){
        Optional<UserProfile> userProfileOptional = userProfileRepository.findById(id);

        if (userProfileOptional.isEmpty()){
            throw new RessourceNotFoundException("Profile with given id not found");
        }
        UserProfile userProfile = userProfileOptional.get();
        updatedUserProfile.setId(userProfile.getId());
        return userProfileRepository.save(updatedUserProfile);
    }
}
