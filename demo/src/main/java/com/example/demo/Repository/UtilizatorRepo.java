package com.example.demo.Repository;

import com.example.demo.Model.Utilizator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//aici vor fi operatiile select-uri pe Utilizator
@Repository
public interface UtilizatorRepo extends CrudRepository<Utilizator,Long> {
    Utilizator findFirstByUtilizatorId(Long id);
    //le faci alea noi din ce iti da el, nu scri de mana!!!!!!!!!!!!
    Utilizator findFirstByEmailAndParola(String email,String parola);
    Utilizator findFirstByNumeAndPrenume(String nume,String prenume);
}
