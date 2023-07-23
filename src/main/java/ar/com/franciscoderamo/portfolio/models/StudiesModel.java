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
import java.time.Year;
import java.util.Date;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "studies")
@Getter @Setter
public class StudiesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String carrer;
    private String institution;
    @Temporal(TemporalType.DATE)
    private int start;
    @Temporal(TemporalType.DATE)
    private int end;
    /*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person")
    PersonModel person;
    */
    
    public StudiesModel() {
    }

    public StudiesModel(int id, String carrer, String institution, int start, int end) {
        this.id = id;
        this.carrer = carrer;
        this.institution = institution;
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