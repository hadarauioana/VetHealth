package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreareContAdmin {
    private String nume;
    private String prenume;
    private String adresa;
    private String email;
    private String nrTel;
    private String parola;
}
