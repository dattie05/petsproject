package petshealthcontrolsystem.Controller;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petshealthcontrolsystem.Repository.AnimalRepository;
import petshealthcontrolsystem.model.Animal;
import petshealthcontrolsystem.service.AnimalService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository repository;

    private AnimalService animalService;

    public AnimalController(AnimalRepository repository,AnimalService animalService){
        this.repository=repository;
        this.animalService=animalService;
    }

    @GetMapping("/all")
    public List<Animal> getAll(){
        return animalService.getAllAnimals();
    }

    @PostMapping("/add")
    public Animal newAnimal(@RequestBody Animal animal){
        return animalService.saveAnimal(animal);
    }

    @GetMapping("/animal{id}")
    public ResponseEntity<Animal>getByIdAnimal(@PathVariable Long id){
        Animal animal=repository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Animal not exist"+id));
        return ResponseEntity.ok(animal);

    }

    @PutMapping("/update/{id}")
    public Animal updateAnimal(@RequestBody Animal animal){
        return this.animalService.updateAnimal(animal);
    }

    @DeleteMapping("/delete")
    public String deleteAnimal(@PathVariable Long id){
        repository.deleteById(id);
        return "Animal deleted!"+id;
    }
}