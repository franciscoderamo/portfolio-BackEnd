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
@Table(name = "skill_group")
@Getter @Setter
public class SkillGroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private int ages;
    private String icon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person")
    PersonModel person;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "skillgroup", cascade = CascadeType.ALL, orphanRemoval = true )
    List<SkillModel> skill;
    
    
    public SkillGroupModel() {
    }

    public SkillGroupModel(int id, String category, int ages, String icon) {
        this.id = id;
        this.category = category;
        this.ages = ages;
        this.icon = icon;
    }
    
    
    /*    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } */

}
