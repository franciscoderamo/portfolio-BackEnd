package ar.com.franciscoderamo.portfolio.controllers;

import ar.com.franciscoderamo.portfolio.models.ExperienceModel;
import ar.com.franciscoderamo.portfolio.interfaces.ExperienceInterface;
import java.util.List;
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
@CrossOrigin(origins = "http:localhost:4200")//https:/  /portfolio-francisco-deramo.web.app
@RequestMapping("/experience")//localhost:8080/experience

public class ExperienceController {
    
    @GetMapping("/hola")
    public String decirHola(){
        return "Hola mundoooo";
    }

    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    private ExperienceInterface experienceService;
    
    @GetMapping ("/all")
    @ResponseBody
    public List<ExperienceModel> getExperience(){
        return experienceService.getExperience();
    }
    
    @GetMapping ("/see/{id}")
    @ResponseBody
    public ExperienceModel seeExperience(@PathVariable Long id){
        return experienceService.findExperience(id);
    }
    
    @PostMapping("/new")
    public ResponseEntity<ExperienceModel> addExperience(@RequestBody ExperienceModel pers){
        experienceService.saveExperience(pers);
        return ResponseEntity.ok().body(pers);
    }
        
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deleteExperience(@PathVariable Long id){
        experienceService.deleteExperience(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity <?> editExperience(@PathVariable("id") Long id, @RequestBody ExperienceModel experience) {
        ExperienceModel exp = experienceService.findExperience(id);
        
        exp.setId(experience.getId());
        exp.setPosition(experience.getPosition());
        exp.setAges(experience.getAges());

       experienceService.saveExperience(exp);
        return new ResponseEntity(HttpStatus.OK);
    }
}
