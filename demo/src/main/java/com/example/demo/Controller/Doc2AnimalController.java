package com.example.demo.Controller;

import com.example.demo.DTO.InserareDoc2Animal;
import com.example.demo.DTO.InserareMesajAnimal;
import com.example.demo.Model.Animal;
import com.example.demo.Model.Doc2Animal;
import com.example.demo.Model.Doctor;
import com.example.demo.Service.Implementation.AnimalServiceImplementation;
import com.example.demo.Service.Implementation.Doc2AnimalServiceImplementation;
import com.example.demo.Service.Implementation.DoctorServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/Doc2Animal")
public class Doc2AnimalController {
    private final Doc2AnimalServiceImplementation doc2AnimalServiceImplementation;
    private final DoctorServiceImplementation doctorServiceImplementation;
    private final AnimalServiceImplementation animalServiceImplementation;
    @PostMapping("/Insert")
    public ResponseEntity insert(@RequestBody Doc2Animal doc2Animal){
        doc2AnimalServiceImplementation.insert(doc2Animal);
        Doc2Animal d=doc2AnimalServiceImplementation.findFirstByIdDoc2Animal(doc2Animal.getIdDoc2Animal());
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }
    @PostMapping("/Update")
    public void update(@RequestBody Doc2Animal doc2Animal){
        doc2AnimalServiceImplementation.update(doc2Animal);
    }
    @PostMapping("/Delete")
    public void delete(@RequestBody Long id){
        Doc2Animal d=doc2AnimalServiceImplementation.findFirstByIdDoc2Animal(id);
        doc2AnimalServiceImplementation.delete(d);
    }
    @PostMapping("/InsertDoc2Animal")
    public ResponseEntity insert(@RequestBody InserareDoc2Animal inserareDoc2Animal){
        Doctor d=doctorServiceImplementation.findFirstByIdDoctor(inserareDoc2Animal.getIdDoctor());
        Animal a=animalServiceImplementation.findFirstByIdAnimal(inserareDoc2Animal.getIdAnimal());
        Doc2Animal d2a=new Doc2Animal(inserareDoc2Animal.getIdDoctor(), inserareDoc2Animal.getIdAnimal());
        if(d.getAnimale().contains(a)==true || a.getIdDoctor()!=null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("doctor already has this animal");
        else {
            d.getD2a().add(d2a);
            d.getAnimale().add(a);
            a.getD2a().add(d2a);
            a.setIdDoctor(d.getIdDoctor());
            doctorServiceImplementation.update(d);
            animalServiceImplementation.update(a);
            doc2AnimalServiceImplementation.insert(d2a);
            return ResponseEntity.status(HttpStatus.OK).body(d2a);
        }
    }
    @PostMapping("/FindByIdDoc2Animal")
    public ResponseEntity findByIdDoc2Animal(@RequestBody Long id){
        Doc2Animal d2a= doc2AnimalServiceImplementation.findFirstByIdDoc2Animal(id);
        return ResponseEntity.status(HttpStatus.OK).body(d2a);
    }
    @PostMapping("/FindByIdDAndIdA")
    public ResponseEntity findByIdDAndIdA(@RequestBody InserareDoc2Animal inserareDoc2Animal){
        Doc2Animal d2a=doc2AnimalServiceImplementation.findFirstByIdDoctorAndIdAnimal(inserareDoc2Animal.getIdDoctor(), inserareDoc2Animal.getIdAnimal());
        return ResponseEntity.status(HttpStatus.OK).body(d2a);
    }
    @PostMapping("/InsertMesFromAnimal")
    public ResponseEntity insertMesFromAnimal(@RequestBody InserareMesajAnimal inserareMesajAnimal){
        Doc2Animal d2a=doc2AnimalServiceImplementation.findFirstByIdDoc2Animal(inserareMesajAnimal.getIdD2A());
        if(inserareMesajAnimal.getMesaj()==""){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("the message doesn't have content");
        }
        else {
            String msg;
            if(Objects.equals(inserareMesajAnimal.getDsaua(), "a"))
            { msg = inserareMesajAnimal.getNumeAnimal() + ": " + inserareMesajAnimal.getMesaj();}
            else msg = "Dr. "+inserareMesajAnimal.getNumeAnimal() + ": " + inserareMesajAnimal.getMesaj();
            d2a.getMesaje().add(msg);
            doc2AnimalServiceImplementation.update(d2a);
            return ResponseEntity.status(HttpStatus.OK).body(d2a);
        }
    }

//    @PostMapping("/FindByIdDAndIdA")
//    public ResponseEntity findByIdDAndIdA(@RequestBody InserareDoc2Animal inserareDoc2Animal){
//        Doc2Animal d2a=doc2AnimalServiceImplementation.findFirstByDoctor_IdDoctorAndAnimal_IdAnimal(inserareDoc2Animal.getIdDoctor(), inserareDoc2Animal.getIdAnimal());
//        return ResponseEntity.status(HttpStatus.OK).body(d2a);
//    }
//    @PostMapping("/FindAllByIdDAndIdA")
//    public ResponseEntity<List<Doc2Animal>> findAllByIdDAndIdA(@RequestBody InserareDoc2Animal inserareDoc2Animal){
//        List<Doc2Animal> d2a= doc2AnimalServiceImplementation.findAllByDoctor_IdDoctorAndAnimal_IdAnimal(inserareDoc2Animal.getIdDoctor(), inserareDoc2Animal.getIdAnimal());
//        return ResponseEntity.status(HttpStatus.OK).body(d2a);
//    }

//    @PostMapping("/InsertMesFromAnimal")
//    public ResponseEntity insertMesFromAnimal(@RequestBody InserareMesajAnimal inserareMesajAnimal) {
//        System.out.println("aici ma sparg");
//        Doc2Animal d2a = doc2AnimalServiceImplementation.findFirstByIdDoc2Animal(inserareMesajAnimal.getIdDoc2Animal());
//        System.out.println("Doc2animal object " + d2a);
//        Animal a = animalServiceImplementation.findFirstByIdAnimal(inserareMesajAnimal.getIdAnimal());
//        System.out.println("Animal object " + a);
//        String msg = a.getNume() + ':' + inserareMesajAnimal.getMesaj();
//        d2a.getMesaje().add(msg);
//        doc2AnimalServiceImplementation.update(d2a);
//
//        return ResponseEntity.status(HttpStatus.OK).body(d2a);
//    }
}
