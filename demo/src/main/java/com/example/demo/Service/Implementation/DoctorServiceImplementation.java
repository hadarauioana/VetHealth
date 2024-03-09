package com.example.demo.Service.Implementation;

import com.example.demo.Model.Doctor;
import com.example.demo.Repository.AnimalRepo;
import com.example.demo.Repository.Doc2AnimalRepo;
import com.example.demo.Repository.DoctorRepo;
import com.example.demo.Repository.UtilizatorRepo;
import com.example.demo.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImplementation implements DoctorService {
    private final DoctorRepo doctorRepo;
    private final UtilizatorRepo utilizatorRepo;
    private final Doc2AnimalRepo doc2AnimalRepo;
    @Override
    public void insert(Doctor doctor) {
//        utilizatorRepo.save(doctor.getUtilizator());
        doctorRepo.save(doctor);
    }

    @Override
    public void update(Doctor doctor) {
//        utilizatorRepo.save(doctor.getUtilizator());
        doctorRepo.save(doctor);
    }

    @Override
    public void delete(Doctor doctor) {
        doctorRepo.delete(doctor);
    }

    @Override
    public Doctor findFirstByIdDoctor(Long id) {
        return doctorRepo.findFirstByIdDoctor(id);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepo.findAll();
    }

    @Override
    public Doctor findFirstByUtilizator_NumeAndUtilizator_Prenume(String nume, String prenume) {
        return doctorRepo.findFirstByUtilizator_NumeAndUtilizator_Prenume(nume,prenume);
    }

    @Override
    public Doctor findFirstByUtilizator_UtilizatorId(Long id) {
        return doctorRepo.findFirstByUtilizator_UtilizatorId(id);
    }
}
