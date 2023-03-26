package ar.com.franciscoderamo.portfolio.repositories;

import ar.com.franciscoderamo.portfolio.models.SkillGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillGroupRepository extends JpaRepository<SkillGroupModel, Long>{
    
}
