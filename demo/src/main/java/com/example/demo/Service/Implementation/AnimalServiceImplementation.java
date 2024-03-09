package com.example.demo.Service.Implementation;

import com.example.demo.Model.Animal;
import com.example.demo.Model.Utilizator;
import com.example.demo.Repository.AnimalRepo;
import com.example.demo.Repository.PacientRepo;
import com.example.demo.Repository.UtilizatorRepo;
import com.example.demo.Service.AnimalService;
import com.example.demo.Service.UtilizatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImplementation implements AnimalService {

    private final AnimalRepo animalRepo;
    @Override
    public void insert(Animal animal) {
        animalRepo.save(animal);
    }

    @Override
    public void update(Animal animal) {
        animalRepo.save(animal);
    }

    @Override
    public void delete(Animal animal) {
        animalRepo.delete(animal);
    }

    @Override
    public Animal findFirstByIdAnimal(Long id) {
        return animalRepo.findFirstByIdAnimal(id);
    }

    @Override
    public Animal findFirstByNume(String nume) {
        return animalRepo.findFirstByNume(nume);
    }

//    @Override
//    public Animal findFirstByNumeAndPacient_IdPacient(String nume, Long id) {
//       // return animalRepo.findFirstByNumeAndPacient_IdPacient(nume,id);
//    }

//    @Override
//    public Animal findAllByPacient_IdPacient(Long id) {
//        return animalRepo.findAllByPacient_IdPacient(id);
//    }

    @Override
    public Animal findFirstByNumeAndIdPacient(String nume, Long idPacient) {
        return animalRepo.findFirstByNumeAndIdPacient(nume,idPacient);
    }

    @Override
    public List<Animal> findAllByIdPacient(Long idPacient) {
        return animalRepo.findAllByIdPacient(idPacient);
    }

    @Override
    public List<Animal> findAll() {
        return animalRepo.findAll();
    }

    @Override
    public Animal findFirstByNumeAndIdDoctor(String nume, Long idDoctor) {
        return animalRepo.findFirstByNumeAndIdDoctor(nume, idDoctor);
    }
}
