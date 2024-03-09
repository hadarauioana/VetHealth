package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //gettere si settere
@NoArgsConstructor //constructor gol
@AllArgsConstructor //constructor cu toate
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAdmin;
    @OneToOne(cascade = CascadeType.ALL)
    private Utilizator utilizator;
    public Admin(Utilizator utilizator) {
        this.utilizator = utilizator;
    }
}
