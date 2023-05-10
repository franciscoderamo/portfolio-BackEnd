    package ar.com.franciscoderamo.portfolio.controllers;

import ar.com.franciscoderamo.portfolio.models.PersonModel;
import ar.com.franciscoderamo.portfolio.interfaces.PersonInterface;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/person")//localhost:8080/person
@CrossOrigin(origins = {"https://portfolio-francisco-deramo.web.app","http://localhost:4200"})
//@CrossOrigin(origins = "http: //localhost:4200")

public class PersonController {
    
    @GetMapping("/hola")
    public String decirHola(){
        return "Hola mundoooo";
    }

    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    private PersonInterface personService;
    
    @GetMapping ("/all")
    @ResponseBody
    public List<PersonModel> getPerson(){
        return personService.getPerson();
    }
    
    @GetMapping ("/see/{id}")
    @ResponseBody
    public PersonModel seePerson(@PathVariable int id){
        return personService.findPerson(id);
    }
    
    @PostMapping("/new")
    public ResponseEntity<PersonModel> addPerson(@RequestBody PersonModel pers){
        personService.savePerson(pers);
        return ResponseEntity.ok().body(pers);
    }
        
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deletePerson(@PathVariable int id){
        personService.deletePerson(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    /*@PutMapping("/edit")
    public ResponseEntity updatePersona(@RequestBody PersonModel pers){
        personService.savePerson(pers);
        return new ResponseEntity(HttpStatus.OK);
    }*/
    
    @PutMapping("/edit/{id}")
    public ResponseEntity <?> editPerson(@PathVariable("id") int id, @RequestBody PersonModel person) {
        PersonModel perso = personService.findPerson(id);

        perso.setName(person.getName());
        perso.setResume(person.getResume());
        perso.setDescription(person.getDescription());
        perso.setAbout(person.getAbout());
        perso.setImage(person.getImage());
        perso.setWhatsapp(person.getWhatsapp());
        perso.setGithub(person.getGithub());
        perso.setLinkedin(person.getLinkedin());
        perso.setEmail(person.getEmail());
        perso.setUbication(person.getUbication());
        perso.setCountry(person.getCountry());

        personService.savePerson(perso);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @GetMapping("/see/1")
    public PersonModel findPersona(){
        return personService.findPerson((int)1);
    }
}