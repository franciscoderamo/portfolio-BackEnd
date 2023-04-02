package ar.com.franciscoderamo.portfolio.services;

import ar.com.franciscoderamo.portfolio.interfaces.WorkedInterface;
import ar.com.franciscoderamo.portfolio.models.WorkedModel;
import ar.com.franciscoderamo.portfolio.repositories.WorkedRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class WorkedService implements WorkedInterface{
//to deploy repository we used Autowired
    //dependency injection
    @Autowired
    public WorkedRepository workedRepo;
    
    @Override
    public List<WorkedModel> getWorked() {
        return workedRepo.findAll();
    }

    @Override
    public void saveWorked(WorkedModel worked) {
        workedRepo.save(worked) ;
    }

    @Override
    public void deleteWorked(Long id) {
        workedRepo.deleteById(id);
    }

    @Override
    public WorkedModel findWorked(Long id) {
        WorkedModel worked = workedRepo.findById(id).orElse(null);
        return worked;
    }    
}
