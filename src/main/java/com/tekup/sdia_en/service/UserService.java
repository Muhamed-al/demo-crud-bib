package com.tekup.sdia_en.service;

import com.tekup.sdia_en.entity.User;
import com.tekup.sdia_en.exception.RessourceExistException;
import com.tekup.sdia_en.exception.RessourceNotFoundException;
import com.tekup.sdia_en.repository.UserProfileRepository;
import com.tekup.sdia_en.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public String deleteUSer(Long id){
        if (!userRepository.existsById(id)){
            throw new RessourceNotFoundException("User with given id not found");
        }

        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    public User update(Long id , User user){
        Optional<User> userOptional =  userRepository.findById(id);

        if (!userOptional.isPresent()){
            throw new RessourceNotFoundException("User with given id not found");
        }

        User updatedUser = userOptional.get();
        user.setId(updatedUser.getId());
        return userRepository.save(user);

    }
}
