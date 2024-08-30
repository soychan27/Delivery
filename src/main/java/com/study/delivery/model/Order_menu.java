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
public class Order_menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordermenukey;

    @ManyToOne
    @JoinColumn(name = "orderkey", nullable = false)
    private Delivery_order order;

    @ManyToOne
    @JoinColumn(name = "menudetailkey", nullable = false)
    private Menu_detail menuDetail;

    private Integer price;
}
