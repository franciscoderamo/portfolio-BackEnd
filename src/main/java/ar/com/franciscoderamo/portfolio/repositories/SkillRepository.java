package ar.com.franciscoderamo.portfolio.repositories;

import ar.com.franciscoderamo.portfolio.models.SkillModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<SkillModel, Long>{
    
}
