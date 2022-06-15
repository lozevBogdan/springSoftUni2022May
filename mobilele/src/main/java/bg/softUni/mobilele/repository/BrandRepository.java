package bg.softUni.mobilele.repository;

import bg.softUni.mobilele.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {



}
