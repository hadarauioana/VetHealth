package com.example.demo.DTO;

import com.example.demo.Model.Animal;
import com.example.demo.Model.Doc2Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InserareMesajAnimal {
    private Long idD2A;
    private String numeAnimal;
    private String mesaj;
    private String dsaua;
}
