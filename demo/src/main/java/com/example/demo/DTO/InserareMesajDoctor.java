package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InserareMesajDoctor {
    private Long idD2A;
    private String numeDoctor;
    private String mesaj;
}
