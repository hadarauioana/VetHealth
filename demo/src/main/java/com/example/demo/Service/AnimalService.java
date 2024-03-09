package com.example.demo.Service;

import com.example.demo.Model.Animal;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AnimalService {
    //aici implementez insert, update, delete
    void insert(Animal animal);
    void update(Animal animal);
    void delete(Animal animal);
    Animal findFirstByIdAnimal(Long id);
    Animal findFirstByNume(String nume);
//    Animal findFirstByNumeAndPacient_IdPacient(String nume, Long id);
//    Animal findAllByPacient_IdPacient(Long id);
    Animal findFirstByNumeAndIdPacient(String nume,Long idPacient);
    List<Animal> findAllByIdPacient(Long idPacient);
    List<Animal> findAll();
    Animal findFirstByNumeAndIdDoctor(String nume,Long idDoctor);
}
