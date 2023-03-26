package ar.com.franciscoderamo.portfolio.interfaces;

import ar.com.franciscoderamo.portfolio.models.PersonModel;
import java.util.List;

public interface PersonInterface {
    
    public List<PersonModel> getPerson ();
    
    public void savePerson (PersonModel per);
    
    public void deletePerson (Long id);
    
    public PersonModel findPerson (Long id);
}
