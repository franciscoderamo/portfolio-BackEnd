package ar.com.franciscoderamo.portfolio.services;

import ar.com.franciscoderamo.portfolio.interfaces.PortfolioInterface;
import ar.com.franciscoderamo.portfolio.models.PortfolioModel;
import ar.com.franciscoderamo.portfolio.repositories.PortfolioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PortfolioService implements PortfolioInterface{
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    public PortfolioRepository portfolioRepo;
    
    @Override
    public List<PortfolioModel> getPortfolio() {
        return portfolioRepo.findAll();
    }

    @Override
    public void savePortfolio(PortfolioModel portfolio) {
        portfolioRepo.save(portfolio) ;
    }

    @Override
    public void deletePortfolio(Long id) {
        portfolioRepo.deleteById(id);
    }

    @Override
    public PortfolioModel findPortfolio(Long id) {
        PortfolioModel portfolio = portfolioRepo.findById(id).orElse(null);
        return portfolio;
    }  
}
