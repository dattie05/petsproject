package petshealthcontrolsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorId;
    private String specialization;
    private String workingExperience;
    private  String firstName;
    private  String lastName;
    private  int phoneNumber;
    private  String email;
    private String address;

    @ManyToMany
    @JoinTable(name="doctor-animal",
    joinColumns = @JoinColumn(name="doctorId"),
    inverseJoinColumns = @JoinColumn(name="animalId")
    )
    private Set<Animal> animals;
}
