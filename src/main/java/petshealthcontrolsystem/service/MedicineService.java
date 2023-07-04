package petshealthcontrolsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petshealthcontrolsystem.Repository.MedicineRepository;
import petshealthcontrolsystem.model.Medicine;

import java.util.List;

@Service
public class MedicineService {

    private MedicineRepository medicineRepository;

    @Autowired
    public MedicineService(MedicineRepository medicineRepository){
        this.medicineRepository=medicineRepository;

    }
    public List<Medicine> getAllMedicines(){
        return medicineRepository.findAll();
    }
    public Medicine saveMedicine(Medicine medicine){
        return medicineRepository.save(medicine);
    }

    public void deleteMedicine(Long id){
        medicineRepository.deleteById(id);
    }

    public Medicine updateMedicine(Medicine medicine){
        Medicine medicine1= this.medicineRepository.findById(medicine.getMedicineCode()).orElse(null);
        medicine1.setMedicineName(medicine.getMedicineName());
        medicine1.setMedicineType(medicine.getMedicineType());
        medicine1.setDescription(medicine.getDescription());
        medicine1.setExpDate(medicine.getExpDate());
        medicine1.setExpireDate(medicine.getExpireDate());

        return this.medicineRepository.save(medicine1);
    }
}