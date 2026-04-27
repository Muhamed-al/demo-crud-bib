package com.tekup.sdia_en.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String username;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Valid Email required")
    private String email;


    @Size(min = 8 , max=50  , message = "Password must be between 8 and 50")
    private String password;

    @JsonIgnoreProperties("user")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_id")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
    private List<Borrow> borrows;





}


