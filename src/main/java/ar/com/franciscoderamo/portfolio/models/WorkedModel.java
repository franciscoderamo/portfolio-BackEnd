package ar.com.franciscoderamo.portfolio.models;

import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
//import java.util.Date;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jobs")
@Getter @Setter
public class WorkedModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String job;
    private String bussines;
    @Temporal(TemporalType.DATE)
    private int start;
    @Temporal(TemporalType.DATE)
    private int end;
    /*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person")
    PersonModel person;
    */
    
    public WorkedModel() {
    }

    public WorkedModel(int id, String job, String bussines, int start, int end) {
        this.id = id;
        this.job = job;
        this.bussines = bussines;
        this.start = start;
        this.end = end;
    }
    
    /*    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } */


}
