package ar.com.franciscoderamo.portfolio.controllers;

import ar.com.franciscoderamo.portfolio.interfaces.PortfolioInterface;
import ar.com.franciscoderamo.portfolio.models.PortfolioModel;
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
@RequestMapping("/portfolio")//localhost:8080/portfolio
@CrossOrigin(origins = "https://portfolio-francisco-deramo.web.app")
//@CrossOrigin(origin = "http://localhost:4200")
public class PortfolioController {
    
    @GetMapping("/hola")
    public String decirHola(){
        return "Hola mundoooo";
    }
    
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    private PortfolioInterface portfolioService;
    
    @GetMapping ("/all")
    @ResponseBody
    public List<PortfolioModel> getPortfolio(){
        return portfolioService.getPortfolio();
    }
    
    @GetMapping ("/see/{id}")
    @ResponseBody
    public PortfolioModel seePortfolio(@PathVariable Long id){
        return portfolioService.findPortfolio(id);
    }
    
    @PostMapping("/new")
    public ResponseEntity<PortfolioModel> addPortfolio(@RequestBody PortfolioModel portfolio){
        portfolioService.savePortfolio(portfolio);
        return ResponseEntity.ok().body(portfolio);
    }
        
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deletePortfolio(@PathVariable Long id){
        portfolioService.deletePortfolio(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity <?> editPortfolio(@PathVariable("id") Long id, @RequestBody PortfolioModel portfolio) {
        PortfolioModel portf = portfolioService.findPortfolio(id);

        portf.setId(portfolio.getId());
        portf.setTitle(portfolio.getTitle());
        portf.setImage(portfolio.getImage());
        portf.setDescription(portfolio.getDescription());
        portf.setLink(portfolio.getLink());

        portfolioService.savePortfolio(portf);
        return new ResponseEntity(HttpStatus.OK);
    }    
}
