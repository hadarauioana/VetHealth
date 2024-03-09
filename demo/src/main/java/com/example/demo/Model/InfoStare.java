package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //gettere si settere
@NoArgsConstructor //constructor gol
@AllArgsConstructor //constructor cu toate
public class InfoStare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idInfo;
    private Long idAnimal;
    private String stare;
    private String detalii;

    public InfoStare(String stare, String detalii) {
        this.stare = stare;
        this.detalii = detalii;
    }
    public InfoStare(String stare, String detalii,Long idAnimal) {
        this.stare = stare;
        this.detalii = detalii;
        this.idAnimal=idAnimal;
    }
}
