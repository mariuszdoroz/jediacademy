package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jediacademy.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleByName(String name);

}
