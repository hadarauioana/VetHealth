package com.example.demo.Service;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Pacient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminService {
    void insert(Admin admin);
    void update(Admin admin);
    void delete(Admin admin);
    Admin findFirstByIdAdmin(Long id);
    List<Admin> findAll();
    Admin findFirstByUtilizator_NumeAndUtilizator_Prenume(String nume,String prenume);
}
