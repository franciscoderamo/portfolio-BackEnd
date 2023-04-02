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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "experiences")
@Getter @Setter
public class ExperienceModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String position;
    private int ages;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person")
    PersonModel person;

    public ExperienceModel() {
    }

    public ExperienceModel(int id, String position, int ages) {
        this.id = id;
        this.position = position;
        this.ages = ages;
    }
    
}
