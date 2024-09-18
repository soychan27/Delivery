    package com.study.delivery.service;

    import com.study.delivery.model.Restaurant;
    import com.study.delivery.repository.RestaurantRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class RestaurantService {

        private final RestaurantRepository restaurantRepository;

        public RestaurantService(RestaurantRepository restaurantRepository) {
            this.restaurantRepository = restaurantRepository;
        }

        public List<Restaurant> getKoreanRestaurants() {
            return restaurantRepository.findByCategory(Restaurant.Category.Korean);
        }

        public List<Restaurant> getChineseRestaurants() {
            return restaurantRepository.findByCategory(Restaurant.Category.Chinese);
        }

        public List<Restaurant> getJapaneseRestaurants() {
            return restaurantRepository.findByCategory(Restaurant.Category.Japanese);
        }

        public List<Restaurant> getItalianRestaurants() {
            return restaurantRepository.findByCategory(Restaurant.Category.Italian);
        }

        public List<Restaurant> getFastFoodRestaurants() {
            return restaurantRepository.findByCategory(Restaurant.Category.FastFood);
        }

        public List<Restaurant> getCafeRestaurants() {
            return restaurantRepository.findByCategory(Restaurant.Category.Cafe);
        }

        public List<Restaurant> getOtherRestaurants() {
            return restaurantRepository.findByCategory(Restaurant.Category.Other);
        }

        public void saveRestaurant(Restaurant restaurant) {
            restaurant.setName(restaurant.getName());
            restaurant.setCategory(restaurant.getCategory());
            restaurant.setImage_name(restaurant.getImage_name());
            restaurant.setImage_path(restaurant.getImage_path());
            restaurant.setOperationhour(restaurant.getOperationhour());
            restaurant.setDeliverytip(restaurant.getDeliverytip());
            restaurant.setStatus(restaurant.getStatus());
            restaurant.setPhone(restaurant.getPhone());
            restaurant.setNotification(restaurant.getNotification());

            restaurantRepository.save(restaurant);
        }

        // 새로운 메서드 추가: 레스토랑 ID로 상세 정보 조회
        public Restaurant getRestaurantById(Integer id) {
            // ID를 통해 레스토랑 정보를 조회하고, 만약 찾지 못하면 null 반환
            Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
            return optionalRestaurant.orElse(null);
        }

        // 영업 중인 가게 리스트 가져오기
        public List<Restaurant> getOpenRestaurants() {
            return restaurantRepository.findByStatus(Restaurant.Status.open);
        }

        // 영업 종료된 가게 리스트 가져오기
        public List<Restaurant> getClosedRestaurants() {
            return restaurantRepository.findByStatus(Restaurant.Status.closed);
        }
    }
