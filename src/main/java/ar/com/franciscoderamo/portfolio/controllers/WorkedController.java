package ar.com.franciscoderamo.portfolio.controllers;

import ar.com.franciscoderamo.portfolio.interfaces.WorkedInterface;
import ar.com.franciscoderamo.portfolio.models.WorkedModel;
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
@CrossOrigin(origins = "https://portfolio-francisco-deramo.web.app")//http:localhost:4200
@RequestMapping("/worked")//localhost:8080/studies

public class WorkedController {
    
    @GetMapping("/hola")
    public String decirHola(){
        return "Hola mundoooo";
    }
    
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    private WorkedInterface workedService;
    
    @GetMapping ("/all")
    @ResponseBody
    public List<WorkedModel> getWorked(){
        return workedService.getWorked();
    }
    
    @GetMapping ("/see/{id}")
    @ResponseBody
    public WorkedModel seeWorked(@PathVariable Long id){
        return workedService.findWorked(id);
    }
    
    @PostMapping("/new")
    public ResponseEntity<WorkedModel> addWorked(@RequestBody WorkedModel pers){
        workedService.saveWorked(pers);
        return ResponseEntity.ok().body(pers);
    }
        
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deleteWorked(@PathVariable Long id){
        workedService.deleteWorked(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity <?> editWorked(@PathVariable("id") Long id, @RequestBody WorkedModel worked) {
        WorkedModel work = workedService.findWorked(id);

        work.setId(worked.getId());
        work.setJob(worked.getJob());
        work.setBussines(worked.getBussines());
        work.setStart(worked.getStart());
        work.setEnd(worked.getEnd());

        workedService.saveWorked(work);
        return new ResponseEntity(HttpStatus.OK);
    }   
}
