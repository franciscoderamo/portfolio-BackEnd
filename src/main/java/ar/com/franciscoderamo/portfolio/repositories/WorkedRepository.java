package ar.com.franciscoderamo.portfolio.repositories;

import ar.com.franciscoderamo.portfolio.models.WorkedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkedRepository extends JpaRepository<WorkedModel, Long>{
    
}
