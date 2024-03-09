package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data //gettere si settere
@NoArgsConstructor //constructor gol
@AllArgsConstructor //constructor cu toate
public class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long utilizatorId;
    private String nume;
    private String prenume;
    private String adresa;
    private String email;
    private String nrTel;
    private String parola;
    //OneToMany
    //private List<Pacient> pacienti;
    //@OneToOne(fetch = FetchType.EAGER)
    //
    public Utilizator(String nume, String prenume, String adresa, String email, String nrTel, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.email = email;
        this.nrTel = nrTel;
        this.parola = parola;
    }
}