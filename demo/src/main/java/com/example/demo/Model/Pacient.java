package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data //gettere si settere
@NoArgsConstructor //constructor gol
@AllArgsConstructor //constructor cu toate
public class Pacient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPacient;
    @OneToOne(cascade = CascadeType.ALL)
    private Utilizator utilizator;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Animal> animale;

    public Pacient(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public Pacient(List<Animal> animale) {
        this.animale = animale;
    }
}
