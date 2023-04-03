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
import lombok.NoArgsConstructor;
import lombok.Setter;
    
@Entity
@Table(name = "persons")
@Getter @Setter
//@NoArgsConstructor
public class PersonModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
    
    public PersonModel () {
    }
    
    public PersonModel (int id, String name, String resume, String description, String about, String image, String whatsapp, String github, String linkedin, String email, String ubication, String country) {
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
    /*
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BankAccountBidirectional> bankAccounts;

    public void addBankAccount(BankAccountBidirectional bankAccount) {
        if (null == bankAccounts) {
            bankAccounts = new HashSet<>();
        }
        bankAccounts.add(bankAccount);
        bankAccount.setBank(this);
    }

    public void removeComment(BankAccountBidirectional bankAccount) {
        bankAccounts.remove(bankAccount);
        bankAccount.setBank(null);
    }*/
}