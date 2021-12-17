package pl.edu.pbs.pai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.pai.model.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
