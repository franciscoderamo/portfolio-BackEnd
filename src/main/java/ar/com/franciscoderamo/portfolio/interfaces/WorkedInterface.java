package ar.com.franciscoderamo.portfolio.interfaces;

import ar.com.franciscoderamo.portfolio.models.WorkedModel;
import java.util.List;

public interface WorkedInterface {
    public List<WorkedModel> getWorked();
    
    public void saveWorked(WorkedModel edu);
    
    public void deleteWorked (Long id);
    
    public WorkedModel findWorked(Long id); 
}
