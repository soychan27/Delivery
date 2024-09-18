package com.study.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userkey;

    private String username;

    private String password;

    private String nickname;

    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Role role = Role.guest;

    private String tel;

    private String provider;

    private String providerid;

    public enum Role {
        guest, boss, admin
    }
}
