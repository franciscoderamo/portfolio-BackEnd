package ar.com.franciscoderamo.portfolio.controllers;

import ar.com.franciscoderamo.portfolio.interfaces.ServicesInterface;
import ar.com.franciscoderamo.portfolio.models.ServicesModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/services")//localhost:8080/services
//@CrossOrigin(origin = "http://localhost:4200")
public class ServicesController {
    
    @GetMapping("/hola")
    public String decirHola(){
        return "Hola mundoooo";
    }
    
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    private ServicesInterface servicesService;
    
    @GetMapping ("/all")
    @ResponseBody
    public List<ServicesModel> getServices(){
        return servicesService.getServices();
    }
    
    @GetMapping ("/see/{id}")
    @ResponseBody
    public ServicesModel seeServices(@PathVariable Long id){
        return servicesService.findServices(id);
    }
    
    @PostMapping("/new")
    public ResponseEntity<ServicesModel> addServices(@RequestBody ServicesModel services){
        servicesService.saveServices(services);
        return ResponseEntity.ok().body(services);
    }
        
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deleteServices(@PathVariable Long id){
        servicesService.deleteServices(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity <?> editServices(@PathVariable("id") Long id, @RequestBody ServicesModel services) {
        ServicesModel serv = servicesService.findServices(id);

        serv.setId(services.getId());
        serv.setName(services.getName());

        servicesService.saveServices(serv);
        return new ResponseEntity(HttpStatus.OK);
    }    
}
