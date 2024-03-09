package com.example.demo.Service;

import com.example.demo.Model.Boala;
import com.example.demo.Model.Utilizator;
import org.springframework.stereotype.Component;

@Component
public interface BoalaService {
    void insert(Boala boala);
    void update(Boala boala);
    void delete(Boala boala);
    Boala findFirstByBoalaId(Long id);
    Boala findFirstByNumeBoala(String nume);
}
