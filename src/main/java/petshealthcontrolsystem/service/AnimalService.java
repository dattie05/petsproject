package petshealthcontrolsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petshealthcontrolsystem.Repository.AnimalRepository;
import petshealthcontrolsystem.model.Animal;

import java.util.List;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository=animalRepository;
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal saveAnimal(Animal animal){
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Long id){
        animalRepository.deleteById(id);
    }

    public Animal updateAnimal(Animal animal){
        Animal animal1=this.animalRepository.findById(animal.getAnimalId()).orElse(null);
        animal1.setAnimalName(animal.getAnimalName());

        return this.animalRepository.save(animal1);
    }
}