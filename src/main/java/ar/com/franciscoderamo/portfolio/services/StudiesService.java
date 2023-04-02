package ar.com.franciscoderamo.portfolio.services;

import ar.com.franciscoderamo.portfolio.interfaces.StudiesInterface;
import ar.com.franciscoderamo.portfolio.models.StudiesModel;
import ar.com.franciscoderamo.portfolio.repositories.StudiesRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class StudiesService implements StudiesInterface{
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    public StudiesRepository studiesRepo;
    
    @Override
    public List<StudiesModel> getStudies() {
        return studiesRepo.findAll();
    }

    @Override
    public void saveStudies(StudiesModel studies) {
        studiesRepo.save(studies) ;
    }

    @Override
    public void deleteStudies(Long id) {
        studiesRepo.deleteById(id);
    }

    @Override
    public StudiesModel findStudies(Long id) {
        StudiesModel studies = studiesRepo.findById(id).orElse(null);
        return studies;
    }    
}
