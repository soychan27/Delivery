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
public class OrderMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordermenukey;

    @ManyToOne
    @JoinColumn(name = "orderkey", nullable = false)
    private DeliveryOrder order;

    @ManyToOne
    @JoinColumn(name = "menudetailkey", nullable = false)
    private MenuDetail menuDetail;

    private Integer price;
}
