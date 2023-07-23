package ar.com.franciscoderamo.portfolio.services;

import ar.com.franciscoderamo.portfolio.interfaces.ExperienceInterface;
import ar.com.franciscoderamo.portfolio.models.ExperienceModel;
import ar.com.franciscoderamo.portfolio.repositories.ExperienceRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienceService implements ExperienceInterface{
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    public ExperienceRepository experienceRepo;
    
    @Override
    public List<ExperienceModel> getExperience() {
        return experienceRepo.findAll();
    }

    @Override
    public void saveExperience(ExperienceModel experience) {
        experienceRepo.save(experience) ;
    }

    @Override
    public void deleteExperience(int id) {
        experienceRepo.deleteById(id);
    }

    @Override
    public ExperienceModel findExperience(int id) {
        ExperienceModel exper = experienceRepo.findById(id).orElse(null);
        return exper;
    } 
    
}
