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
@Table(name = "worked")
@Getter @Setter
public class WorkedModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String job;
    private String bussines;
    private Long start;
    private Long end;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person")
    private PersonModel person;
    
    
    public WorkedModel() {
    }

    public WorkedModel(Long id, String job, String bussines, Long start, Long end, PersonModel person) {
        this.id = id;
        this.job = job;
        this.bussines = bussines;
        this.start = start;
        this.end = end;
        this.person = person;
    }
    
    /*    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } */


}
