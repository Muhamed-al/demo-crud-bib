package com.tekup.sdia_en.service;

import com.tekup.sdia_en.entity.User;
import com.tekup.sdia_en.exception.RessourceExistException;
import com.tekup.sdia_en.exception.RessourceNotFoundException;
import com.tekup.sdia_en.repository.UserProfileRepository;
import com.tekup.sdia_en.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;

    public UserService(UserProfileRepository userProfileRepository, UserRepository userRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        if (userRepository.existsByEmail(user.getEmail())){
            throw new RessourceExistException("User with given email " + user.getEmail() + " Already exist");
        }
        return this.userRepository.save(user);
    }

    public User getById(Long id){
        if (!userRepository.existsById(id)){
            throw new RessourceNotFoundException("User with given ID " + id + " not found");
        }
        return userRepository.findById(id).get();
    }
}
