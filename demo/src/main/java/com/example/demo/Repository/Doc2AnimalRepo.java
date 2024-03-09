package com.example.demo.Repository;


import com.example.demo.Model.Doc2Animal;
import com.example.demo.Model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Doc2AnimalRepo extends CrudRepository<Doc2Animal,Long> {
    Doc2Animal findFirstByIdDoc2Animal(Long id);
    Doc2Animal findFirstByIdDoctorAndIdAnimal(Long idD,Long idA);
    List<Doc2Animal> findAllByIdDoctor(long id);
//    Doc2Animal findFirstByDoctor_IdDoctorAndAnimal_IdAnimal(Long idDoctor,Long idAnimal);
//    List<Doc2Animal> findAllByDoctor_IdDoctorAndAnimal_IdAnimal(Long idDoctor, Long idAnimal);
}
