package ar.com.franciscoderamo.portfolio.interfaces;

import ar.com.franciscoderamo.portfolio.models.PortfolioModel;
import java.util.List;

public interface PortfolioInterface {
    
    public List<PortfolioModel> getPortfolio();
    
    public void savePortfolio(PortfolioModel portf);
    
    public void deletePortfolio (Long id);
    
    public PortfolioModel findPortfolio(Long id);
}
