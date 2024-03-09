package com.example.demo.Service.Implementation;

import com.example.demo.Model.Doctor;
import com.example.demo.Model.InfoStare;
import com.example.demo.Repository.AnimalRepo;
import com.example.demo.Repository.DoctorRepo;
import com.example.demo.Repository.InfoStareRepo;
import com.example.demo.Service.InfoStareService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoStareServiceImplementation implements InfoStareService {
    private final InfoStareRepo infoStareRepo;
    private final AnimalRepo animalRepo;
    @Override
    public void insert(InfoStare infoStare) {
        //animalRepo.save(infoStare.getAnimal());
        infoStareRepo.save(infoStare);
    }

    @Override
    public void update(InfoStare infoStare) {
        //animalRepo.save(infoStare.getAnimal());
        infoStareRepo.save(infoStare);
    }

    @Override
    public void delete(InfoStare infoStare) {
        infoStareRepo.delete(infoStare);
    }

    @Override
    public InfoStare findFirstByIdInfo(Long id) {
        return infoStareRepo.findFirstByIdInfo(id);
    }

    @Override
    public List<InfoStare> findAllByIdAnimal(Long id) {
        return infoStareRepo.findAllByIdAnimal(id);
    }
}
