package com.example.demo.Controller;

import com.example.demo.DTO.CautareDoctor;
import com.example.demo.DTO.CreareCont;
import com.example.demo.DTO.UpdateCont;
import com.example.demo.Model.*;
import com.example.demo.Service.Implementation.Doc2AnimalServiceImplementation;
import com.example.demo.Service.Implementation.DoctorServiceImplementation;
import com.example.demo.Service.Implementation.PacientServiceImplementation;
import com.example.demo.Service.Implementation.UtilizatorServiceImplementation;
import com.example.demo.Service.PacientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/Pacient")
public class PacientController {
    private final PacientServiceImplementation pacientServiceImplementation;
    private final Doc2AnimalServiceImplementation doc2AnimalServiceImplementation;
    private final DoctorServiceImplementation doctorServiceImplementation;
    private final UtilizatorServiceImplementation utilizatorServiceImplementation;
    @PostMapping("/Insert")
    public ResponseEntity insert(@RequestBody Pacient pacient){
        pacientServiceImplementation.insert(pacient);
        Pacient p=pacientServiceImplementation.findFirstByIdPacient(pacient.getIdPacient());
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }
    @PostMapping("/Update")
    public void update(@RequestBody Pacient pacient){
        pacientServiceImplementation.update(pacient);
    }
    @PostMapping("/Delete")
    public void delete(@RequestBody Long id){
        Pacient p=pacientServiceImplementation.findFirstByIdPacient(id);
//        List<Doc2Animal> d2aList=doc2AnimalServiceImplementation.findAllByIdDoctor(id);
//        for(int i=0;i<d2aList.size();i++) {
//            Doc2Animal d2aObj=doc2AnimalServiceImplementation.findFirstByIdDoc2Animal(d2aList.get(i).getIdDoc2Animal());
//            Doctor doctor=doctorServiceImplementation.findFirstByIdDoctor(d2aObj.getIdDoctor());
//            doctor.setD2a(null);
//            d2aObj.setIdDoctor(null);
//            System.out.println("d2a obj: "+d2aObj);
//            //doc2AnimalServiceImplementation.delete(d2aObj);
//        }
        pacientServiceImplementation.delete(p);
    }
    @PostMapping("/CreateCont")
    public ResponseEntity createCont(@RequestBody CreareCont creareCont){
        if (creareCont.getEmail().endsWith("@doctor.vetcj")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nu se pot crea conturi de doctor, doar adminul poate crea");
        }
        Utilizator u= new Utilizator(creareCont.getNume(),creareCont.getPrenume(),creareCont.getAdresa(),creareCont.getEmail(),creareCont.getNrTel(),creareCont.getParola());
        Pacient pnew=new Pacient(u);
        pacientServiceImplementation.insert(pnew);
        Pacient p=pacientServiceImplementation.findFirstByIdPacient(pnew.getIdPacient());
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }
    @PostMapping("/GetByUtilizatorId")
    public ResponseEntity findPacientByUtilizatorId(@RequestBody Long id){
        Pacient p=pacientServiceImplementation.findFirstByUtilizator_UtilizatorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }

    @PostMapping("/UpdateCont")
    public ResponseEntity updateCont(@RequestBody UpdateCont updateCont){
        Pacient p=pacientServiceImplementation.findFirstByIdPacient(updateCont.getIdPacient());
        p.getUtilizator().setUtilizatorId(p.getUtilizator().getUtilizatorId());
        p.getUtilizator().setNume(updateCont.getNume());
        p.getUtilizator().setPrenume(updateCont.getPrenume());
        p.getUtilizator().setAdresa(updateCont.getAdresa());
        p.getUtilizator().setEmail(updateCont.getEmail());
        p.getUtilizator().setNrTel(updateCont.getNrTel());
        p.getUtilizator().setParola(updateCont.getParola());
        pacientServiceImplementation.update(p);
        Pacient pfind=pacientServiceImplementation.findFirstByIdPacient(updateCont.getIdPacient());
        return ResponseEntity.status(HttpStatus.OK).body(pfind);
    }
    @GetMapping("/All")
    public ResponseEntity<List<Pacient>> getAllPacients() {
        List<Pacient> pacients = pacientServiceImplementation.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pacients);
    }

    @PostMapping("/findByNumeAndPrenume")
    public ResponseEntity findPacientByNumeAndPrenume(@RequestBody CautareDoctor cautareDoctor){
        Pacient p=pacientServiceImplementation.findFirstByUtilizator_NumeAndUtilizator_Prenume(cautareDoctor.getNume(), cautareDoctor.getPrenume());
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }
}
