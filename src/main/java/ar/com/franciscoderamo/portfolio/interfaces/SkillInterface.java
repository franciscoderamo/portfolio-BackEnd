package ar.com.franciscoderamo.portfolio.interfaces;

import ar.com.franciscoderamo.portfolio.models.SkillModel;
import java.util.List;


public interface SkillInterface {
    
    public List<SkillModel> getSkill();
    
    public void saveSkill(SkillModel skill);
    
    public void deleteSkill (Long id);
    
    public SkillModel findSkill(Long id);
}
