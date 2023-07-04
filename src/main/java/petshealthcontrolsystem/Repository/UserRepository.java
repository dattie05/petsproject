package petshealthcontrolsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petshealthcontrolsystem.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
