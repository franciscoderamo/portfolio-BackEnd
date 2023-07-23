package ar.com.franciscoderamo.portfolio.interfaces;

import ar.com.franciscoderamo.portfolio.models.ExperienceModel;
import java.util.List;

public interface ExperienceInterface {
    
    public List<ExperienceModel> getExperience();
    
    public void saveExperience(ExperienceModel experience);
    
    public void deleteExperience (int id);
    
    public ExperienceModel findExperience(int id);

}
