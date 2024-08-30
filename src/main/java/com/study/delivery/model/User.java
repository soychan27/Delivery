package com.study.delivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userkey;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private Role role; // 이 부분을 Enum 타입으로 사용하려면 따로 Enum 클래스를 정의할 수 있습니다.

    private String tel;

    private String provider;

    private String providerid;

    public enum Role {
        CUSTOMER, BOSS, ADMIN
    }
}
