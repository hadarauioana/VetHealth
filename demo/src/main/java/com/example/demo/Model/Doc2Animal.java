package com.example.demo.Model;

import com.fasterxml.jackson.annotation.*;
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
public class Doc2Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDoc2Animal;
    private Long idDoctor;
    private Long idAnimal;
    @ElementCollection
    private List<String> mesaje;

    public Doc2Animal(Long idDoctor, Long idAnimal) {
        this.idDoctor = idDoctor;
        this.idAnimal = idAnimal;
    }
}
