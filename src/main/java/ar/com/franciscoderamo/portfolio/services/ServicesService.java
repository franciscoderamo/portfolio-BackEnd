package ar.com.franciscoderamo.portfolio.services;

import ar.com.franciscoderamo.portfolio.interfaces.ServicesInterface;
import ar.com.franciscoderamo.portfolio.models.ServicesModel;
import ar.com.franciscoderamo.portfolio.repositories.ServicesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesService implements ServicesInterface{
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    public ServicesRepository servicesRepo;
    
    @Override
    public List<ServicesModel> getServices() {
        return servicesRepo.findAll();
    }

    @Override
    public void saveServices(ServicesModel services) {
        servicesRepo.save(services) ;
    }

    @Override
    public void deleteServices(Long id) {
        servicesRepo.deleteById(id);
    }

    @Override
    public ServicesModel findServices(Long id) {
        ServicesModel services = servicesRepo.findById(id).orElse(null);
        return services;
    }  
}
