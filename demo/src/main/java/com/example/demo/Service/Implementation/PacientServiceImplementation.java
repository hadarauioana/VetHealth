package com.example.demo.Service.Implementation;

import com.example.demo.Model.Doctor;
import com.example.demo.Model.Pacient;
import com.example.demo.Repository.DoctorRepo;
import com.example.demo.Repository.PacientRepo;
import com.example.demo.Repository.UtilizatorRepo;
import com.example.demo.Service.PacientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacientServiceImplementation implements PacientService {
    private final PacientRepo pacientRepo;
    private final UtilizatorRepo utilizatorRepo;
    @Override
    public void insert(Pacient pacient) {
//        utilizatorRepo.save(pacient.getUtilizator());
        pacientRepo.save(pacient);
    }

    @Override
    public void update(Pacient pacient) {
//        utilizatorRepo.save(pacient.getUtilizator());
        pacientRepo.save(pacient);
    }

    @Override
    public void delete(Pacient pacient) {
        pacientRepo.delete(pacient);
    }

    @Override
    public Pacient findFirstByIdPacient(Long id) {
        return pacientRepo.findFirstByIdPacient(id);
    }

    @Override
    public Pacient findFirstByUtilizator_UtilizatorId(Long id) {
        return pacientRepo.findFirstByUtilizator_UtilizatorId(id);
    }

    @Override
    public List<Pacient> findAll() {
        return pacientRepo.findAll();
    }

    @Override
    public Pacient findFirstByUtilizator_NumeAndUtilizator_Prenume(String nume, String prenume) {
        return pacientRepo.findFirstByUtilizator_NumeAndUtilizator_Prenume(nume,prenume);
    }

}
