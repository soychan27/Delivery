package com.study.delivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restkey;

    @ManyToOne
    @JoinColumn(name = "userkey")
    private User user;

    private Integer deliverytip;

    private Category category; // Enum 타입으로 변경

    private String name;

    private String image_name;

    private String image_path;

    private String operationhour;

    private Status status; // Enum 타입으로 변경

    private String phone;

    private String notification;

    public enum Category {
        KOREAN, CHINESE, ITALIAN, FASTFOOD, CAFE, OTHER
    }

    public enum Status {
        OPEN, CLOSED
    }
}
