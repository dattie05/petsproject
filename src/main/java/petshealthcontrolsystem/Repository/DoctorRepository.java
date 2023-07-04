package petshealthcontrolsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petshealthcontrolsystem.model.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
