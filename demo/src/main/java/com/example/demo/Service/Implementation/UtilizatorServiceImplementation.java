package com.example.demo.Service.Implementation;

import com.example.demo.Model.Utilizator;
import com.example.demo.Repository.UtilizatorRepo;
import com.example.demo.Service.UtilizatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UtilizatorServiceImplementation implements UtilizatorService {

    private final UtilizatorRepo utilizatorRepo;
    @Override
    public void insert(Utilizator utilizator) {
        utilizatorRepo.save(utilizator);
    }

    @Override
    public void update(Utilizator utilizator) {
        utilizatorRepo.save(utilizator);
    }

    @Override
    public void delete(Utilizator utilizator) {
        utilizatorRepo.delete(utilizator);
    }

    @Override
    public Utilizator findFirstByUtilizatorId(Long id) {
        return utilizatorRepo.findFirstByUtilizatorId(id);
    }

    @Override
    public Utilizator findFirstByEmailAndParola(String email, String parola) {
        return utilizatorRepo.findFirstByEmailAndParola(email,parola);
    }

    @Override
    public Utilizator findFirstByNumeAndPrenume(String nume, String prenume) {
        return utilizatorRepo.findFirstByNumeAndPrenume(nume,prenume);
    }
}
