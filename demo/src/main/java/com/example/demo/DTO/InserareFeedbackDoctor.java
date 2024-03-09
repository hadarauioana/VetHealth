package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InserareFeedbackDoctor {
    private String nume;
    private String prenume;
    private String feedback;
}
