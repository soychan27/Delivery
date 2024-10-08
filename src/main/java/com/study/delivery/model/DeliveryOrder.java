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
public class DeliveryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderkey;

    @ManyToOne
    @JoinColumn(name = "userkey", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restkey")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "addrkey")
    private Address address;

    private String req;
}
