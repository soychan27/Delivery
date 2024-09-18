package com.study.delivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class MenuDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menudetailkey;

    @ManyToOne
    @JoinColumn(name = "menukey", nullable = false)
    private Menu menu;

    private Integer quantity;

    private Integer price;
}
