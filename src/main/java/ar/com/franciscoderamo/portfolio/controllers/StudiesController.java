package ar.com.franciscoderamo.portfolio.controllers;

import ar.com.franciscoderamo.portfolio.interfaces.StudiesInterface;
import ar.com.franciscoderamo.portfolio.models.StudiesModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studies")//localhost:8080/studies
@CrossOrigin(origins = {"https://portfolio-francisco-deramo.web.app","http://localhost:4200"})
//@CrossOrigin(origins = "http: //localhost:4200")

public class StudiesController {
    
    @GetMapping("/hola")
    public String decirHola(){
        return "Hola mundoooo";
    }
    
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    private StudiesInterface studiesService;
    
    @GetMapping ("/all")
    @ResponseBody
    public List<StudiesModel> getStudies(){
        return studiesService.getStudies();
    }
    
    @GetMapping ("/see/{id}")
    @ResponseBody
    public StudiesModel seeStudies(@PathVariable Long id){
        return studiesService.findStudies(id);
    }
    
    @PostMapping("/new")
    public ResponseEntity<StudiesModel> addStudies(@RequestBody StudiesModel studies){
        studiesService.saveStudies(studies);
        return ResponseEntity.ok().body(studies);
    }
        
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deleteStudies(@PathVariable Long id){
        studiesService.deleteStudies(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity <?> editStudies(@PathVariable("id") Long id, @RequestBody StudiesModel studies) {
        StudiesModel studie = studiesService.findStudies(id);

        studie.setId(studies.getId());
        studie.setCarrer(studies.getCarrer());
        studie.setInstitution(studies.getInstitution());
        studie.setStart(studies.getStart());
        studie.setEnd(studies.getEnd());

        studiesService.saveStudies(studie);
        return new ResponseEntity(HttpStatus.OK);
    }    
}
