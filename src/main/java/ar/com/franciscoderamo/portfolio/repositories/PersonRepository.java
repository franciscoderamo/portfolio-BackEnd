package ar.com.franciscoderamo.portfolio.repositories;

import ar.com.franciscoderamo.portfolio.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Integer>{
    
}
