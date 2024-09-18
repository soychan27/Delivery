package com.study.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restkey;

    @ManyToOne
    @JoinColumn(name = "userkey")
    private User user;  // User 엔티티가 잘 정의되어 있는지 확인

    private Integer deliverytip;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String name;

    private String image_name;

    private String image_path;

    private String operationhour;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String phone;

    private String notification;

    public enum Category {
        Korean, Chinese, Italian, Japanese, FastFood, Cafe, Other
    }

    public enum Status {
        open, closed
    }
}
