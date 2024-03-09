package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InserareVoucher {
    private Long idAnimal;
    private String numeVoucher;
    private String numeBeneficiar;
    private int valoare;
}
