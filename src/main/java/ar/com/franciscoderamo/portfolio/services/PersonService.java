package ar.com.franciscoderamo.portfolio.services;

import ar.com.franciscoderamo.portfolio.interfaces.PersonInterface;
import ar.com.franciscoderamo.portfolio.models.PersonModel;
import ar.com.franciscoderamo.portfolio.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonService implements PersonInterface{
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    public PersonRepository personRepository;
    
    @Override
    public List<PersonModel> getPerson() {
        List<PersonModel> listPerson = personRepository.findAll();
        return listPerson;
    }

    @Override
    public void savePerson(PersonModel per) {
        personRepository.save(per) ;
    }

    @Override
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    @Override
    public PersonModel findPerson(int id) {
        PersonModel person = personRepository.findById(id).orElse(null);
        return person;
    }
    
}
