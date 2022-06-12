package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.RoleEntity;
import bg.softuni.pathfinder.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    Optional<RoleEntity> findByRole(RoleEnum role);
}
