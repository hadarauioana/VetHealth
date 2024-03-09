package com.example.demo.Service.Implementation;

import com.example.demo.Model.Doc2Animal;
import com.example.demo.Model.Doctor;
import com.example.demo.Repository.AnimalRepo;
import com.example.demo.Repository.Doc2AnimalRepo;
import com.example.demo.Repository.DoctorRepo;
import com.example.demo.Repository.UtilizatorRepo;
import com.example.demo.Service.Doc2AnimalService;
import com.example.demo.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Doc2AnimalServiceImplementation implements Doc2AnimalService {
    private final DoctorRepo doctorRepo;
    private final AnimalRepo animalRepo;
    private final Doc2AnimalRepo doc2AnimalRepo;
    @Override
    public void insert(Doc2Animal doc2Animal) {
//        doctorRepo.save(doc2Animal.getDoctor());
//        animalRepo.save(doc2Animal.getAnimal());
        doc2AnimalRepo.save(doc2Animal);
    }

    @Override
    public void update(Doc2Animal doc2Animal) {
//        doctorRepo.save(doc2Animal.getDoctor());
//        animalRepo.save(doc2Animal.getAnimal());
        doc2AnimalRepo.save(doc2Animal);
    }

    @Override
    public void delete(Doc2Animal doc2Animal) {
        doc2AnimalRepo.delete(doc2Animal);
    }

    @Override
    public Doc2Animal findFirstByIdDoc2Animal(Long id) {
        return doc2AnimalRepo.findFirstByIdDoc2Animal(id);
    }

    @Override
    public Doc2Animal findFirstByIdDoctorAndIdAnimal(Long idD, Long idA) {
        return doc2AnimalRepo.findFirstByIdDoctorAndIdAnimal(idD,idA);
    }

    @Override
    public List<Doc2Animal> findAllByIdDoctor(long id) {
        return doc2AnimalRepo.findAllByIdDoctor(id);
    }

//    @Override
//    public Doc2Animal findFirstByDoctor_IdDoctorAndAnimal_IdAnimal(Long idDoctor, Long idAnimal) {
//        return doc2AnimalRepo.findFirstByDoctor_IdDoctorAndAnimal_IdAnimal(idDoctor,idAnimal);
//    }
//
//    @Override
//    public List<Doc2Animal> findAllByDoctor_IdDoctorAndAnimal_IdAnimal(Long idDoctor, Long idAnimal) {
//        return doc2AnimalRepo.findAllByDoctor_IdDoctorAndAnimal_IdAnimal(idDoctor,idAnimal);
//    }

}
