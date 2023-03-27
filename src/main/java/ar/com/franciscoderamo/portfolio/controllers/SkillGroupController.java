package ar.com.franciscoderamo.portfolio.controllers;

import ar.com.franciscoderamo.portfolio.interfaces.SkillGroupInterface;
import ar.com.franciscoderamo.portfolio.models.SkillGroupModel;
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
@CrossOrigin(origins = "http:localhost:4200")//https:/  /portfolio-francisco-deramo.web.app
@RequestMapping("/skillgroup")//localhost:8080/skillgroup

public class SkillGroupController {
    
    @GetMapping("/hola")
    public String decirHola(){
        return "Hola mundoooo";
    }
    
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    private SkillGroupInterface skillGroupService;
    
    @GetMapping ("/all")
    @ResponseBody
    public List<SkillGroupModel> getSkillGroup(){
        return skillGroupService.getSkillGroup();
    }
    
    @GetMapping ("/see/{id}")
    @ResponseBody
    public SkillGroupModel seeSkillGroup(@PathVariable Long id){
        return skillGroupService.findSkillGroup(id);
    }
    
    @PostMapping("/new")
    public ResponseEntity<SkillGroupModel> addStudies(@RequestBody SkillGroupModel skillgroup){
        skillGroupService.saveSkillGroup(skillgroup);
        return ResponseEntity.ok().body(skillgroup);
    }
        
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deleteSkillGroup(@PathVariable Long id){
        skillGroupService.deleteSkillGroup(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity <?> editSkillGroup(@PathVariable("id") Long id, @RequestBody SkillGroupModel skillgroup) {
        SkillGroupModel skillg = skillGroupService.findSkillGroup(id);

        skillg.setId(skillgroup.getId());
        skillg.setCategory(skillgroup.getCategory());
        skillg.setAges(skillgroup.getAges());
        skillg.setIcon(skillgroup.getIcon());

        skillGroupService.saveSkillGroup(skillg);
        return new ResponseEntity(HttpStatus.OK);
    }   
}
