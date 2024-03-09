package com.example.demo.Repository;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Pacient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepo extends CrudRepository<Admin,Long> {
    Admin findFirstByIdAdmin(Long id);
    List<Admin> findAll();
    Admin findFirstByUtilizator_NumeAndUtilizator_Prenume(String nume,String prenume);
}
