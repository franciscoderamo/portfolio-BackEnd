package ar.com.franciscoderamo.portfolio.services;

import ar.com.franciscoderamo.portfolio.interfaces.SkillInterface;
import ar.com.franciscoderamo.portfolio.models.SkillModel;
import ar.com.franciscoderamo.portfolio.repositories.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements SkillInterface{
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    public SkillRepository skillRepo;
    
    @Override
    public List<SkillModel> getSkill() {
        return skillRepo.findAll();
    }

    @Override
    public void saveSkill(SkillModel skill) {
        skillRepo.save(skill) ;
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public SkillModel findSkill(Long id) {
        SkillModel skill = skillRepo.findById(id).orElse(null);
        return skill;
    }    
}
