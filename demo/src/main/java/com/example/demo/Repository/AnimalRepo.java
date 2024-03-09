package com.example.demo.Repository;

import com.example.demo.Model.Animal;
import com.example.demo.Model.Utilizator;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepo extends CrudRepository<Animal,Long> {
    Animal findFirstByIdAnimal(Long id);
    //le faci alea noi din ce iti da el, nu scri de mana!!!!!!!!!!!!
    Animal findFirstByNume(String nume);
    Animal findFirstByNumeAndIdPacient(String nume,Long idPacient);
    List<Animal> findAllByIdPacient(Long idPacient);
    List<Animal> findAll();
    Animal findFirstByNumeAndIdDoctor(String nume,Long idDoctor);
//    Animal findFirstByNumeAndPacient_IdPacient(String nume, Long id);
    //Animal findAllByPacient_IdPacient(Long id);
}
