package com.example.demo.Controller;

import com.example.demo.DTO.*;
import com.example.demo.Model.*;
import com.example.demo.Service.Implementation.AnimalServiceImplementation;
import com.example.demo.Service.Implementation.Doc2AnimalServiceImplementation;
import com.example.demo.Service.Implementation.DoctorServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/Doctor")
public class DoctorController {
    private final DoctorServiceImplementation doctorServiceImplementation;
    private final Doc2AnimalServiceImplementation doc2AnimalServiceImplementation;
    private final AnimalServiceImplementation animalServiceImplementation;
    @PostMapping("/Insert")
    public ResponseEntity insert(@RequestBody Doctor doctor){
        doctorServiceImplementation.insert(doctor);
        Doctor d=doctorServiceImplementation.findFirstByIdDoctor(doctor.getIdDoctor());
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }
    @PostMapping("/Update")
    public void update(@RequestBody Doctor doctor){
        doctorServiceImplementation.update(doctor);
    }
    @PostMapping("/Delete")
    public void delete(@RequestBody Long id){
        Doctor d=doctorServiceImplementation.findFirstByIdDoctor(id);
        d.setAnimale(null);
        List<Doc2Animal> d2aList=doc2AnimalServiceImplementation.findAllByIdDoctor(id);
        for(int i=0;i<d2aList.size();i++) {
            Doc2Animal d2aObj=doc2AnimalServiceImplementation.findFirstByIdDoc2Animal(d2aList.get(i).getIdDoc2Animal());
            Animal animal=animalServiceImplementation.findFirstByIdAnimal(d2aObj.getIdAnimal());
            animal.setD2a(null);
            animal.setIdDoctor(null);
            System.out.println("animal obj: "+animal);
            d2aObj.setIdAnimal(null);
            System.out.println("d2a obj: "+d2aObj);
            //doc2AnimalServiceImplementation.delete(d2aObj);
        }

        doctorServiceImplementation.delete(d);
    }
    @GetMapping("/All")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorServiceImplementation.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }
    @PostMapping("/findByNumeAndPrenume")
    public ResponseEntity findDoctorByNumeAndPrenume(@RequestBody CautareDoctor cautareDoctor){
        Doctor d=doctorServiceImplementation.findFirstByUtilizator_NumeAndUtilizator_Prenume(cautareDoctor.getNume(), cautareDoctor.getPrenume());
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }

    @PostMapping("/CreareContDoctor")
    public ResponseEntity insertDoctor(@RequestBody CreareContDoctor creareContDoctor){
        Utilizator u= new Utilizator(creareContDoctor.getNume(),creareContDoctor.getPrenume(),creareContDoctor.getAdresa(),creareContDoctor.getEmail(),creareContDoctor.getNrTel(),creareContDoctor.getParola());
        Doctor dnew=new Doctor(creareContDoctor.getSpecializare(),u);
        doctorServiceImplementation.insert(dnew);
        Doctor d=doctorServiceImplementation.findFirstByIdDoctor(dnew.getIdDoctor());
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }
    @PostMapping("/UpdateCont")
    public ResponseEntity updateCont(@RequestBody UpdateContDoctor updateContDoctor){
        Doctor d=doctorServiceImplementation.findFirstByIdDoctor(updateContDoctor.getIdDoctor());
        d.getUtilizator().setUtilizatorId(d.getUtilizator().getUtilizatorId());
        d.getUtilizator().setNume(updateContDoctor.getNume());
        d.getUtilizator().setPrenume(updateContDoctor.getPrenume());
        d.getUtilizator().setAdresa(updateContDoctor.getAdresa());
        d.getUtilizator().setEmail(updateContDoctor.getEmail());
        d.getUtilizator().setNrTel(updateContDoctor.getNrTel());
        d.getUtilizator().setParola(updateContDoctor.getParola());
        d.setSpecializare(updateContDoctor.getSpecializare());
        doctorServiceImplementation.update(d);
        Doctor df=doctorServiceImplementation.findFirstByIdDoctor(updateContDoctor.getIdDoctor());
        return ResponseEntity.status(HttpStatus.OK).body(df);
    }
    @PostMapping("/GetByUtilizatorId")
    public ResponseEntity findPacientByUtilizatorId(@RequestBody Long id){
        Doctor d=doctorServiceImplementation.findFirstByUtilizator_UtilizatorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }
    @PostMapping("/AddFeedToDoctor")
    public ResponseEntity addFeed(@RequestBody FeedbackDoctor feedbackDoctor){
        Doctor d=doctorServiceImplementation.findFirstByUtilizator_UtilizatorId(feedbackDoctor.getIdDoctor());
        d.getFeedback().add(feedbackDoctor.getFeedback());
        doctorServiceImplementation.update(d);
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }
    @PostMapping("/AddFeedbackToDoctor")
    public ResponseEntity addFeedback(@RequestBody FeedbackDoctor feedbackDoctor){
        Doctor d=doctorServiceImplementation.findFirstByIdDoctor(feedbackDoctor.getIdDoctor());
        System.out.println("doctorul: "+d);
        d.getFeedback().add(feedbackDoctor.getFeedback());
        doctorServiceImplementation.update(d);
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }
    @PostMapping("/InsertFeedToDoctor")
    public ResponseEntity insertFeed(@RequestBody InserareFeedbackDoctor inserareFeedbackDoctor){
        Doctor d=doctorServiceImplementation.findFirstByUtilizator_NumeAndUtilizator_Prenume(inserareFeedbackDoctor.getNume(),inserareFeedbackDoctor.getPrenume());
        System.out.println("doctorul :"+d);
        d.getFeedback().add(inserareFeedbackDoctor.getFeedback());
        doctorServiceImplementation.update(d);
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }

    @PostMapping("/GetByDoctorId")
    public ResponseEntity findByDoctorId(@RequestBody Long id){
        Doctor d=doctorServiceImplementation.findFirstByIdDoctor(id);
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }

}
