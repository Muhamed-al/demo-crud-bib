package com.tekup.sdia_en.repository;

import com.tekup.sdia_en.entity.User;
import com.tekup.sdia_en.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile , Long> {

    UserProfile findByUser(User user);

    UserProfile findByFullname(String fullname);


}
