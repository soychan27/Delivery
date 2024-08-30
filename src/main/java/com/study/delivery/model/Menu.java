package com.study.delivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Menu {
    @Id
    private Integer menukey;

    private Restaurant restaurant;

    private String image_name;

    private String image_path;

    private String name;

    private Integer price;

    private String content;
}
