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
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVoucher;
    private String numeBeneficiar;
    private String numeVoucher;
    private int valoare;

    public Voucher(String numeBeneficiar, String numeVoucher, int valoare) {
        this.numeBeneficiar = numeBeneficiar;
        this.numeVoucher = numeVoucher;
        this.valoare = valoare;
    }
}
