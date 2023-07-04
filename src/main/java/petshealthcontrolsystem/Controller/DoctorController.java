package petshealthcontrolsystem.Controller;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petshealthcontrolsystem.Repository.DoctorRepository;
import petshealthcontrolsystem.model.Doctor;
import petshealthcontrolsystem.service.DoctorService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    private DoctorService doctorService;

    public DoctorController(DoctorRepository repository, DoctorService doctorService){
        this.repository=repository;
        this.doctorService=doctorService;
    }

    @GetMapping("/all")
    public List<Doctor> getAll() {
        return doctorService.getAllDoctors();
    }

    @PostMapping("/add")
    public Doctor newDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }
    @GetMapping("doctor/{id}")
    public ResponseEntity<Doctor> getByIdDoctor(@PathVariable Long id) {
        Doctor doctor = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("doctor not exist" + id));
        return ResponseEntity.ok(doctor);
    }

    @PutMapping("/update/{id}")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return this.doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Long id){
        repository.deleteById(id);
        return "doctor deleted!"+id;



    }
}