package com.example.demo.Service;

import com.example.demo.Model.Utilizator;
import org.springframework.stereotype.Component;
//se pune pt interfetele de service
@Component
public interface UtilizatorService {
    //aici implementez insert, update, delete
    void insert(Utilizator utilizator);
    void update(Utilizator utilizator);
    void delete(Utilizator utilizator);
    Utilizator findFirstByUtilizatorId(Long id);
    Utilizator findFirstByEmailAndParola(String email,String parola);
    Utilizator findFirstByNumeAndPrenume(String nume,String prenume);
}
