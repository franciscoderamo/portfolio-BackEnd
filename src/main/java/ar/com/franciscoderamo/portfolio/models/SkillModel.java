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
@Table(name = "skill")
@Getter @Setter
public class SkillModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int porcentage;
   
  
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_skill_group")
    SkillGroupModel skillgroup;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person")
    PersonModel person;
    
    
    public SkillModel() {
    }

    public SkillModel(int id, String title, int porcentage) {
        this.id = id;
        this.title = title;
        this.porcentage = porcentage;
    }
    
    /*    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } */

}
