package petshealthcontrolsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petshealthcontrolsystem.Repository.DoctorRepository;
import petshealthcontrolsystem.model.Doctor;

import java.util.List;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }
    public void deleteDoctor(Long id){
        doctorRepository.deleteById(id);
    }

    public Doctor updateDoctor(Doctor doctor){
        Doctor doctor1=this.doctorRepository.findById(doctor.getDoctorId()).orElse(null);
        doctor1.setFirstName(doctor.getFirstName());
        doctor1.setLastName(doctor.getLastName());
        doctor1.setSpecialization(doctor.getSpecialization());
        doctor1.setWorkingExperience(doctor.getWorkingExperience());
        doctor1.setPhoneNumber(doctor.getPhoneNumber());
        doctor1.setEmail(doctor.getEmail());
        doctor1.setAddress(doctor.getAddress());

        return this.doctorRepository.save(doctor1);
    }
}