package com.example.demo.Controller;

import com.example.demo.DTO.*;
import com.example.demo.Model.Admin;
import com.example.demo.Model.Doctor;
import com.example.demo.Model.Pacient;
import com.example.demo.Model.Utilizator;
import com.example.demo.Service.Implementation.AdminServiceImplementation;
import com.example.demo.Service.Implementation.PacientServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/Admin")
public class AdminController {
    private final AdminServiceImplementation adminServiceImplementation;
    @PostMapping("/Insert")
    public ResponseEntity insert(@RequestBody Admin admin){
        adminServiceImplementation.insert(admin);
        Admin a=adminServiceImplementation.findFirstByIdAdmin(admin.getIdAdmin());
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
    @PostMapping("/Update")
    public void update(@RequestBody Admin admin){
        adminServiceImplementation.update(admin);
    }
    @PostMapping("/Delete")
    public void delete(@RequestBody Long id){
        Admin a=adminServiceImplementation.findFirstByIdAdmin(id);
        adminServiceImplementation.delete(a);
    }
    @PostMapping("/CreateCont")
    public ResponseEntity createCont(@RequestBody CreareContAdmin creareContAdmin){
        Utilizator u= new Utilizator(creareContAdmin.getNume(),creareContAdmin.getPrenume(),creareContAdmin.getAdresa(),creareContAdmin.getEmail(),creareContAdmin.getNrTel(),creareContAdmin.getParola());
        System.out.println(u);
        Admin adnew=new Admin(u);
        adminServiceImplementation.insert(adnew);
        Admin ad=adminServiceImplementation.findFirstByIdAdmin(adnew.getIdAdmin());
        return ResponseEntity.status(HttpStatus.OK).body(ad);
    }
    @GetMapping("/All")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminServiceImplementation.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(admins);
    }
    @PostMapping("/UpdateCont")
    public ResponseEntity updateCont(@RequestBody UpdateContAdmin updateContAdmin){
        if(updateContAdmin.getIdAdmin()==0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("nu ai selectat admin");
        }
        Admin ad=adminServiceImplementation.findFirstByIdAdmin(updateContAdmin.getIdAdmin());
        ad.getUtilizator().setUtilizatorId(ad.getUtilizator().getUtilizatorId());
        ad.getUtilizator().setNume(updateContAdmin.getNume());
        ad.getUtilizator().setPrenume(updateContAdmin.getPrenume());
        ad.getUtilizator().setAdresa(updateContAdmin.getAdresa());
        ad.getUtilizator().setEmail(updateContAdmin.getEmail());
        ad.getUtilizator().setNrTel(updateContAdmin.getNrTel());
        ad.getUtilizator().setParola(updateContAdmin.getParola());
        adminServiceImplementation.update(ad);
        Admin adfind=adminServiceImplementation.findFirstByIdAdmin(updateContAdmin.getIdAdmin());
        return ResponseEntity.status(HttpStatus.OK).body(adfind);
    }
    @PostMapping("/findByNumeAndPrenume")
    public ResponseEntity findAdminByNumeAndPrenume(@RequestBody CautareDoctor cautareDoctor){
        Admin ad=adminServiceImplementation.findFirstByUtilizator_NumeAndUtilizator_Prenume(cautareDoctor.getNume(), cautareDoctor.getPrenume());
        return ResponseEntity.status(HttpStatus.OK).body(ad);
    }
}
