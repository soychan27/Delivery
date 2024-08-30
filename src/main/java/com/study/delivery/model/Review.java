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
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewkey;

    @ManyToOne
    @JoinColumn(name = "restkey", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "userkey", nullable = false)
    private User user;

    private Integer rating;

    private String content;

    private String image_name;

    private String image_path;
}
