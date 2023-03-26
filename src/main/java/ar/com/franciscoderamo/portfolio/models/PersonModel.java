package ar.com.franciscoderamo.portfolio.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
    
@Entity
@Table(name = "person")
@Getter @Setter
public class PersonModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String resume;
    private String description;
    private String about;
    private String image;
    private String whatsapp;
    private String github;
    private String linkedin;
    private String email;
    private String ubication;
    private String country;
    
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL )
    List<StudiesModel> studies;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL )
    List<ExperienceModel> experience;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL )
    List<WorkedModel> worked;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL )
    List<SkillGroupModel> skillgroup;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL )
    List<SkillModel> skill;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL )
    List<ServicesModel> services;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL )
    List<TaskModel> task;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL )
    List<PortfolioModel> portfolio;
    
    public PersonModel () {
    }
    
    public PersonModel (Long id, String name, String resume, String description, String about, String image, String whatsapp, String github, String linkedin, String email, String ubication, String country) {
        this.id = id;
        this.name = name;
        this.resume = resume;
        this.description = description;
        this.about = about;
        this.image = image;
        this.whatsapp = whatsapp;
        this.github = github;
        this.linkedin = linkedin;
        this.email = email;
        this.ubication = ubication;
        this.country = country;
    }
}