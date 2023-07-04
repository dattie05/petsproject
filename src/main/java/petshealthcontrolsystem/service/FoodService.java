package petshealthcontrolsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petshealthcontrolsystem.Repository.FoodRepository;
import petshealthcontrolsystem.Repository.UserRepository;
import petshealthcontrolsystem.model.Food;
import petshealthcontrolsystem.model.User;

import java.util.List;
@Service
public class FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFoods(){
        return foodRepository.findAll();
    }
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }

    public Food updateFood(Food food) {
        Food food1 = this.foodRepository.findById(food.getFoodId()).orElse(null);
        food1.setFoodName(food.getFoodName());
        food1.setFoodNutrient(food.getFoodNutrient());
        food1.setFoodType(food.getFoodNutrient());
        food1.setDescription(food.getDescription());
        food1.setExpireDate(food.getExpireDate());
        food1.setExpDate(food.getExpDate());

        return this.foodRepository.save(food1);
    }
}

