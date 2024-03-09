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
public class Boala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "utilizator_id", unique = true, nullable = false)
    private Long boalaId;
    private String numeBoala;
    private String descriereBoala;

    public Boala(String numeBoala, String descriereBoala) {
        this.numeBoala = numeBoala;
        this.descriereBoala = descriereBoala;
    }
}
