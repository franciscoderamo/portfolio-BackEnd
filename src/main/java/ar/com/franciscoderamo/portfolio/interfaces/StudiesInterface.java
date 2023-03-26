package ar.com.franciscoderamo.portfolio.interfaces;

import ar.com.franciscoderamo.portfolio.models.StudiesModel;
import java.util.List;


public interface StudiesInterface {
    
    public List<StudiesModel> getStudies();
    
    public void saveStudies(StudiesModel edu);
    
    public void deleteStudies (Long id);
    
    public StudiesModel findStudies(Long id);

}
