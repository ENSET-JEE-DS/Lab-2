package application.manytomany.repositories;

import application.manytomany.entites.Role;
import application.manytomany.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
