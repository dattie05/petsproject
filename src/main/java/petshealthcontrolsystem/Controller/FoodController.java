package petshealthcontrolsystem.Controller;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petshealthcontrolsystem.Repository.FoodRepository;
import petshealthcontrolsystem.model.Food;
import petshealthcontrolsystem.service.FoodService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    private FoodRepository repository;
    private FoodService foodService;

    public FoodController(FoodRepository repository, FoodService foodService) {
        this.repository = repository;
        this.foodService = foodService;
    }

    @GetMapping("/all")
    public List<Food> getAll(){
        return foodService.getAllFoods();
    }
    @PostMapping("/add")
    public  Food newFood(@RequestBody Food food){
        return foodService.saveFood(food);

    }

    @GetMapping("/food/{id}")
    public ResponseEntity<Food>   getByIdFood(@PathVariable Long id){
        Food food = repository.findById(id).
                orElseThrow(() ->new ResourceNotFoundException("user does not exist" +id));
        return ResponseEntity.ok(food);
    }
    @PutMapping("/update/{id}")
    public  Food updateFood(@RequestBody Food food){
        return  this.foodService.updateFood(food);
    }
    @DeleteMapping("/del/{id}")
    public String deleteFood(@PathVariable Long id){
        repository.deleteById(id);
        return "food deleted!"+id;
    }

}
