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
@Table(name = "tasks")
@Getter @Setter
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person")
    PersonModel person;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_service")
    ServicesModel services;
    
    
    public TaskModel() {
    }

    public TaskModel(int id, String title) {
        this.id = id;
        this.title = title;
    } 
    
    /*    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } */

}
