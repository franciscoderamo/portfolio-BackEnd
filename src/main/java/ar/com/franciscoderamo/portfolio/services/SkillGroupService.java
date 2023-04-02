package ar.com.franciscoderamo.portfolio.services;

import ar.com.franciscoderamo.portfolio.interfaces.SkillGroupInterface;
import ar.com.franciscoderamo.portfolio.models.SkillGroupModel;
import ar.com.franciscoderamo.portfolio.repositories.SkillGroupRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class SkillGroupService implements SkillGroupInterface{
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    public SkillGroupRepository skillGroupRepo;
    
    @Override
    public List<SkillGroupModel> getSkillGroup() {
        return skillGroupRepo.findAll();
    }

    @Override
    public void saveSkillGroup(SkillGroupModel skillGroup) {
        skillGroupRepo.save(skillGroup) ;
    }

    @Override
    public void deleteSkillGroup(Long id) {
        skillGroupRepo.deleteById(id);
    }

    @Override
    public SkillGroupModel findSkillGroup(Long id) {
        SkillGroupModel skillGroup = skillGroupRepo.findById(id).orElse(null);
        return skillGroup;
    }    
}
