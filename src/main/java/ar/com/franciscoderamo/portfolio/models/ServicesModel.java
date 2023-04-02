package ar.com.franciscoderamo.portfolio.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "services")
@Getter @Setter
public class ServicesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person")
    PersonModel person;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "services", cascade = CascadeType.ALL, orphanRemoval = true )
    List<TaskModel> task;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "services", cascade = CascadeType.ALL, orphanRemoval = true )
    List<PortfolioModel> portfolio;
    
    
    public ServicesModel() {
    }
    
    
    public ServicesModel(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /*    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } */
}
