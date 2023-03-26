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
@Table(name = "skill")
@Getter @Setter
public class SkillModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int porcentage;
   
  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_skill_group")
    private SkillGroupModel skillgroup;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person")
    private PersonModel person;
    
    public SkillModel() {
    }

    public SkillModel(Long id, String title, int porcentage) {
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
