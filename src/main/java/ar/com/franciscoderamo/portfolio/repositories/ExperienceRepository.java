package ar.com.franciscoderamo.portfolio.repositories;

import ar.com.franciscoderamo.portfolio.models.ExperienceModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<ExperienceModel, Long>{
    //create method to later call it in the service, in "getExperienceModel" findBy + parameter
    //public abstract List<ExperienceModel> findByPosition(String position);
}
