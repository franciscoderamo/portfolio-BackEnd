package ar.com.franciscoderamo.portfolio.interfaces;

import ar.com.franciscoderamo.portfolio.models.SkillGroupModel;
import java.util.List;

public interface SkillGroupInterface {
    public List<SkillGroupModel> getSkillGroup();
    
    public void saveSkillGroup(SkillGroupModel edu);
    
    public void deleteSkillGroup (Long id);
    
    public SkillGroupModel findSkillGroup (Long id);
}
