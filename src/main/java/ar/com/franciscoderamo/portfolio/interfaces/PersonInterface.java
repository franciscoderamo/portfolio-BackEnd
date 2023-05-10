package ar.com.franciscoderamo.portfolio.interfaces;

import ar.com.franciscoderamo.portfolio.models.PersonModel;
import java.util.List;

public interface PersonInterface {
    // Traer una lista de persona
    public List<PersonModel> getPerson ();
    // Guardar un objeto de tipo PersonModel
    public void savePerson (PersonModel per);
    // Eliminar un objeto pero lo buscamos por ID
    public void deletePerson (int id);
    // Buscar una persona por ID
    public PersonModel findPerson (int id);
}
