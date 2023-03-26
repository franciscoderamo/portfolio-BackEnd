package ar.com.franciscoderamo.portfolio.interfaces;

import ar.com.franciscoderamo.portfolio.models.ServicesModel;
import java.util.List;

public interface ServicesInterface {
    
    public List<ServicesModel> getServices();
    
    public void saveServices(ServicesModel serv);
    
    public void deleteServices (Long id);
    
    public ServicesModel findServices(Long id);
}
