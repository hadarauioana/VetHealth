package com.example.demo.Repository;

import com.example.demo.Model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends CrudRepository<Doctor,Long> {
    Doctor findFirstByIdDoctor(Long id);
    List<Doctor> findAll();
    Doctor findFirstByUtilizator_NumeAndUtilizator_Prenume(String nume,String prenume);
    Doctor findFirstByUtilizator_UtilizatorId(Long id);

}
