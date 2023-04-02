package ar.com.franciscoderamo.portfolio.controllers;

import ar.com.franciscoderamo.portfolio.interfaces.SkillInterface;
import ar.com.franciscoderamo.portfolio.models.SkillModel;
import java.util.List;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("/skill")//localhost:8080/skill
@CrossOrigin(origins = {"https://portfolio-francisco-deramo.web.app","http://localhost:4200"})
//@CrossOrigin(origins = "http: //localhost:4200")

public class SkillControler {
    
    @GetMapping("/hola")
    public String decirHola(){
        return "Hola mundoooo";
    }
    
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    private SkillInterface skillService;
    
    @GetMapping ("/all")
    @ResponseBody
    public List<SkillModel> getSkill(){
        return skillService.getSkill();
    }
    
    @GetMapping ("/see/{id}")
    @ResponseBody
    public SkillModel seeSkill(@PathVariable Long id){
        return skillService.findSkill(id);
    }
    
    @PostMapping("/new")
    public ResponseEntity<SkillModel> addStudies(@RequestBody SkillModel skill){
        skillService.saveSkill(skill);
        return ResponseEntity.ok().body(skill);
    }
        
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deleteSkill(@PathVariable Long id){
        skillService.deleteSkill(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity <?> editSkill(@PathVariable("id") Long id, @RequestBody SkillModel skill) {
        SkillModel ski = skillService.findSkill(id);

        ski.setId(skill.getId());
        ski.setTitle(skill.getTitle());
        ski.setPorcentage(skill.getPorcentage());

        skillService.saveSkill(ski);
        return new ResponseEntity(HttpStatus.OK);
    }   
}
