package petshealthcontrolsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petshealthcontrolsystem.model.Medicine;
@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Long> {
}
