package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data //gettere si settere
@NoArgsConstructor //constructor gol
@AllArgsConstructor //constructor cu toate
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDoctor;
    private String specializare;
    @ElementCollection
    private List<String> feedback;
    @OneToOne(cascade = CascadeType.ALL)
    private Utilizator utilizator;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Doc2Animal> d2a;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Animal> animale;

    public Doctor(String specializare, Utilizator utilizator) {
        this.specializare = specializare;
        this.utilizator = utilizator;
    }

    public Doctor(List<Doc2Animal> d2a, List<Animal> animale) {
        this.d2a = d2a;
        this.animale = animale;
    }

    public Doctor(List<String> feedback) {
        this.feedback = feedback;
    }
}
