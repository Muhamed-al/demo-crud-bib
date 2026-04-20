package com.tekup.sdia_en.entity;


import jakarta.persistence.*;

@Entity
public class UserProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String phone;
    private String address;

    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private User user;
}
