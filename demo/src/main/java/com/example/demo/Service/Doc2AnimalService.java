package com.example.demo.Service;

import com.example.demo.Model.Doc2Animal;

import java.util.List;


public interface Doc2AnimalService {
    void insert(Doc2Animal doc2Animal);
    void update(Doc2Animal doc2Animal);
    void delete(Doc2Animal doc2Animal);
    Doc2Animal findFirstByIdDoc2Animal(Long id);
    Doc2Animal findFirstByIdDoctorAndIdAnimal(Long idD,Long idA);
    List<Doc2Animal> findAllByIdDoctor(long id);
//    Doc2Animal findFirstByDoctor_IdDoctorAndAnimal_IdAnimal(Long idDoctor,Long idAnimal);
//    List<Doc2Animal> findAllByDoctor_IdDoctorAndAnimal_IdAnimal(Long idDoctor, Long idAnimal);
}
