package com.study.delivery.repository;

import com.study.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findByCategory(Restaurant.Category category);

    List<Restaurant> findByStatus(Restaurant.Status status);
}
