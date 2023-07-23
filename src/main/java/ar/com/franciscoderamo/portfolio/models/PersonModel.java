package ar.com.franciscoderamo.portfolio.models;

import com.sun.istack.NotNull;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
//import java.util.List;
import lombok.Getter;
import lombok.Setter;
    
@Entity
@Table(name = "persons")
@Getter @Setter
//@NoArgsConstructor
public class PersonModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 45, message = "'Name' no cumple con la longitud")
    private String name;
    @NotNull
    @Size(min = 1, max = 60, message = "'Resume' no cumple con la longitud")
    private String resume;
    @NotNull
    @Size(min = 1, max = 150, message = "'Description' no cumple con la longitud")
    private String description;
    @NotNull
    @Size(min = 1, max = 250, message = "'About' no cumple con la longitud")
    private String about;
    @NotNull
    @Size(min = 1, max = 200, message = "'Image' no cumple con la longitud. Ingrese el link de la imagen")
    private String image;
    //@Size(min = 10, max = 20, message = "'Whatsapp' debe tener una longitud de 13 numeros. Ej. 5491140406060")
    private Long whatsapp;
    @Size(min = 10, max = 100, message = "'GitHub' no cumple con la longitud")
    private String github;
    @Size(min = 10, max = 100, message = "'Linkedin' no cumple con la longitud")
    private String linkedin;
    @NotNull
    @Size(min = 6, max = 100, message = "'Email' no cumple con la longitud")
    private String email;
    @NotNull
    @Size(min = 1, max = 45, message = "'Email' no cumple con la longitud")
    private String ubication;
    @NotNull
    @Size(min = 3, max = 45, message = "'Country' no cumple con la longitud")
    private String country;
    
    /*
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    List<StudiesModel> studies;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ExperienceModel> experience;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    List<WorkedModel> worked;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    List<SkillGroupModel> skillgroup;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    List<SkillModel> skill;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ServicesModel> services;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    List<TaskModel> task;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PortfolioModel> portfolio;
    */
    
    public PersonModel () {
    }
    
    public PersonModel (int id, String name, String resume, String description, String about, String image, Long whatsapp, String github, String linkedin, String email, String ubication, String country) {
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