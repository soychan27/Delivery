package com.study.delivery.controller;

import com.study.delivery.model.Restaurant;
import com.study.delivery.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ListController {

    private final RestaurantService restaurantService;

    public ListController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/list")
    public String list() {
        return "restaurantlist";
    }

    @GetMapping("/list/Korean")
    public String korean(Model model) {
        List<Restaurant> koreanRestaurants = restaurantService.getKoreanRestaurants();
        model.addAttribute("restaurants", koreanRestaurants);
        return "Category/koreanlist";
    }

    @GetMapping("/list/Chinese")
    public String chinese(Model model) {
        List<Restaurant> chineseRestaurants = restaurantService.getChineseRestaurants();
        model.addAttribute("restaurants", chineseRestaurants);
        return "Category/chineselist";
    }

    @GetMapping("/list/Japanese")
    public String japanese(Model model) {
        List<Restaurant> japaneseRestaurants = restaurantService.getJapaneseRestaurants();
        model.addAttribute("restaurants", japaneseRestaurants);
        return "Category/japaneselist";
    }

    @GetMapping("/list/Italian")
    public String italian(Model model) {
        List<Restaurant> italianRestaurants = restaurantService.getItalianRestaurants();
        model.addAttribute("restaurants", italianRestaurants);
        return "Category/italianlist";
    }

    @GetMapping("/list/FastFood")
    public String fastfood(Model model) {
        List<Restaurant> fastFoodRestaurants = restaurantService.getFastFoodRestaurants();
        model.addAttribute("restaurants", fastFoodRestaurants);
        return "Category/fastfoodlist";
    }

    @GetMapping("/list/Cafe")
    public String cafe(Model model) {
        List<Restaurant> cafeRestaurants = restaurantService.getCafeRestaurants();
        model.addAttribute("restaurants", cafeRestaurants);
        return "Category/cafelist";
    }

    @GetMapping("/list/Other")
    public String other(Model model) {
        List<Restaurant> otherRestaurants = restaurantService.getOtherRestaurants();
        model.addAttribute("restaurants", otherRestaurants);
        return "Category/otherlist";
    }


    @GetMapping("/list/join")
    public String join(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "restaurantjoin";
    }

    @PostMapping("/list/join/pro")
    public String joinSubmit(@ModelAttribute Restaurant restaurant, BindingResult result){
        if (result.hasErrors()) {
            return "restaurantlist";
        }
        restaurantService.saveRestaurant(restaurant);
        return "redirect:/list";
    }

    @GetMapping("/restaurant/{id}")
    public String restaurantDetail(@PathVariable("id") Integer id, Model model) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        if (restaurant == null) {
            return "redirect:/list"; // Redirect if the restaurant is not found
        }
        model.addAttribute("restaurant", restaurant);
        return "restaurantdetail"; // Name of the detail view template
    }

    @GetMapping("/list/Status/OPEN")
    public String openRestaurants(Model model) {
        List<Restaurant> openRestaurants = restaurantService.getOpenRestaurants();
        model.addAttribute("restaurants", openRestaurants);
        return "status/openlist"; // 영업 중인 가게 리스트를 보여주는 템플릿
    }

    @GetMapping("/list/Status/CLOSED")
    public String closedRestaurants(Model model) {
        List<Restaurant> closedRestaurants = restaurantService.getClosedRestaurants();
        model.addAttribute("restaurants", closedRestaurants);
        return "status/closedlist"; // 영업 종료된 가게 리스트를 보여주는 템플릿
    }

}
