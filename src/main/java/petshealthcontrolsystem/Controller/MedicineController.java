package petshealthcontrolsystem.Controller;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petshealthcontrolsystem.Repository.DoctorRepository;
import petshealthcontrolsystem.Repository.MedicineRepository;
import petshealthcontrolsystem.model.Doctor;
import petshealthcontrolsystem.model.Medicine;
import petshealthcontrolsystem.model.User;
import petshealthcontrolsystem.service.MedicineService;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/medicine")
public class MedicineController {

    @Autowired
    private MedicineRepository repository;

    public MedicineService medicineService;

    public MedicineController(MedicineRepository repository, MedicineService medicineService) {
        this.repository = repository;
        this.medicineService = medicineService;
    }

    @PostMapping("/Medicine")
    public Medicine newMedicine(@RequestBody Medicine medicine) {
        return medicineService.saveMedicine(medicine);
    }

    @GetMapping("/all")
    public List<Medicine> getAll(){
        return medicineService.getAllMedicines();
    }
    @GetMapping("/Medicine/{id}")
    public ResponseEntity<Medicine> getByIdMedicine(@PathVariable Long id){
        Medicine medicine= repository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("medicine not exist"+id));
        return ResponseEntity.ok(medicine);
    }

@PutMapping("/update/{id}")
    public Medicine updateMedicine(@RequestBody Medicine medicine){
        return  medicineService.updateMedicine(medicine);}

  public String deleteMedicine(@PathVariable Long id){
        repository.deleteById(id);
        return "medicine deleted!"+id;
}

}


