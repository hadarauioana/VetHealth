package com.example.demo.Service.Implementation;

import com.example.demo.Model.Boala;
import com.example.demo.Repository.BoalaRepo;
import com.example.demo.Service.BoalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoalaServiceImplementation implements BoalaService {
    private final BoalaRepo boalaRepo;

    @Override
    public void insert(Boala boala) {
        boalaRepo.save(boala);
    }

    @Override
    public void update(Boala boala) {
        boalaRepo.save(boala);
    }

    @Override
    public void delete(Boala boala) {
        boalaRepo.delete(boala);
    }

    @Override
    public Boala findFirstByBoalaId(Long id) {
        return boalaRepo.findFirstByBoalaId(id);
    }
    @Override
    public Boala findFirstByNumeBoala(String nume) {
        return boalaRepo.findFirstByNumeBoala(nume);
    }
}
