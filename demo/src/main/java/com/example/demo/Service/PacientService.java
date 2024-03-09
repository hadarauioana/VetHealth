package com.example.demo.Service;

import com.example.demo.Model.Doctor;
import com.example.demo.Model.Pacient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PacientService {
    void insert(Pacient pacient);
    void update(Pacient pacient);
    void delete(Pacient pacient);
    Pacient findFirstByIdPacient(Long id);
    Pacient findFirstByUtilizator_UtilizatorId(Long id);
    List<Pacient> findAll();
    Pacient findFirstByUtilizator_NumeAndUtilizator_Prenume(String nume,String prenume);
}
