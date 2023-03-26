package ar.com.franciscoderamo.portfolio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "portfolio")
@Getter @Setter
public class PortfolioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private String description;
    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person")
    private PersonModel person;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_services")
    private ServicesModel services;
    
    public PortfolioModel() {
    }
    
    public PortfolioModel(Long id, String title, String image, String description, String link) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.link = link;
    }
    
    /*    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } */

}
