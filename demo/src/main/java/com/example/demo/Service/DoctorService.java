package com.example.demo.Service;

import com.example.demo.Model.Doctor;
import com.example.demo.Model.Utilizator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DoctorService {
    void insert(Doctor doctor);
    void update(Doctor doctor);
    void delete(Doctor doctor);
    Doctor findFirstByIdDoctor(Long id);
    List<Doctor> findAll();
    Doctor findFirstByUtilizator_NumeAndUtilizator_Prenume(String nume,String prenume);
    Doctor findFirstByUtilizator_UtilizatorId(Long id);
}
