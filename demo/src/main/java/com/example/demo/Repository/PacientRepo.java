package com.example.demo.Repository;

import com.example.demo.Model.Pacient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacientRepo extends CrudRepository<Pacient,Long> {
    Pacient findFirstByIdPacient(Long id);
    Pacient findFirstByUtilizator_UtilizatorId(Long id);
    List<Pacient> findAll();
    Pacient findFirstByUtilizator_NumeAndUtilizator_Prenume(String nume,String prenume);
}
