package com.tekup.sdia_en.service;

import com.tekup.sdia_en.entity.User;
import com.tekup.sdia_en.repository.UserProfileRepository;
import com.tekup.sdia_en.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;

    public UserService(UserProfileRepository userProfileRepository, UserRepository userRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
    }

    public User getById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }

    public User createUser(User user){
        //userProfileRepository.save(user.getUserProfile());
        return this.userRepository.save(user);
    }
}
