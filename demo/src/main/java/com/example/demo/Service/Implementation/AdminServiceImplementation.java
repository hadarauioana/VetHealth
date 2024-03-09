package com.example.demo.Service.Implementation;

import com.example.demo.Model.Admin;
import com.example.demo.Repository.AdminRepo;
import com.example.demo.Repository.UtilizatorRepo;
import com.example.demo.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImplementation implements AdminService {
    private final UtilizatorRepo utilizatorRepo;
    private final AdminRepo adminRepo;
    @Override
    public void insert(Admin admin) {
//        utilizatorRepo.save(admin.getUtilizator());
        adminRepo.save(admin);
    }

    @Override
    public void update(Admin admin) {
//        utilizatorRepo.save(admin.getUtilizator());
        adminRepo.save(admin);
    }

    @Override
    public void delete(Admin admin) {
        adminRepo.delete(admin);
    }

    @Override
    public Admin findFirstByIdAdmin(Long id) {
        return adminRepo.findFirstByIdAdmin(id);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepo.findAll();
    }

    @Override
    public Admin findFirstByUtilizator_NumeAndUtilizator_Prenume(String nume, String prenume) {
        return adminRepo.findFirstByUtilizator_NumeAndUtilizator_Prenume(nume,prenume);
    }
}
