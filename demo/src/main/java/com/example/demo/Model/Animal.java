package com.example.demo.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.Model.Voucher;

import java.util.List;

@Entity
@Data //gettere si settere
@NoArgsConstructor //constructor gol
@AllArgsConstructor //constructor cu toate
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAnimal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAnimal;
    private String nume;
    private String rasa;
    private int varsta;
    private String sex;
    private String steril;
    private String nrCip;
    private String tipAnimal;
    private Long idPacient;
    private Long idDoctor;
    @ElementCollection
    private List<String> feedbacks;
    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Doc2Animal> d2a;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<InfoStare> istoric;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Voucher> vouchers;

    public Animal(String nume, String rasa, int varsta, String sex, String steril, String nrCip, String tipAnimal,Long idPacient) {
        this.nume = nume;
        this.rasa = rasa;
        this.varsta = varsta;
        this.sex = sex;
        this.steril = steril;
        this.nrCip = nrCip;
        this.tipAnimal = tipAnimal;
        this.idPacient=idPacient;
    }

}
