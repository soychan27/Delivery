package com.study.delivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Menu {
    @Id
    private Integer menukey;

    @ManyToOne
    @JoinColumn(name = "restkey")
    private Restaurant restaurant;

    private String image_name;

    private String image_path;

    private String name;

    private Integer price;

    private String content;
}
