package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAnimal {
    private Long idAnimal;
    private String nume;
    private String rasa;
    private int varsta;
    private String sex;
    private String steril;
    private String nrCip;
    private String tipAnimal;
    private Long idPacient;
}
