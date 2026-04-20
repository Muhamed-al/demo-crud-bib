package com.tekup.sdia_en.entity;


import jakarta.persistence.*;
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


    private String username;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name="profile_id")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
    private List<Borrow> borrows;





}


