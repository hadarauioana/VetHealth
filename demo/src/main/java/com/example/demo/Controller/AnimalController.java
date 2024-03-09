package com.example.demo.Controller;

import com.example.demo.DTO.*;
import com.example.demo.Model.Animal;
import com.example.demo.Model.Pacient;
import com.example.demo.Model.Utilizator;
import com.example.demo.Service.AnimalService;
import com.example.demo.Service.Implementation.AnimalServiceImplementation;
import com.example.demo.Service.Implementation.PacientServiceImplementation;
import com.example.demo.Service.Implementation.UtilizatorServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.Doctor;

import java.util.List;

//se ocupa cu ce imi vine de la interfata
@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/Animal")
public class AnimalController {

    private final AnimalServiceImplementation animalServiceImplementation;
    private final PacientServiceImplementation pacientServiceImplementation;
    @PostMapping("/Insert")
    public ResponseEntity insert(@RequestBody Animal animal){
        animalServiceImplementation.insert(animal);
        Animal u=animalServiceImplementation.findFirstByIdAnimal(animal.getIdAnimal());
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }
    @PostMapping("/Update")
    public void update(@RequestBody Animal animal){
        animalServiceImplementation.update(animal);
    }
    @PostMapping("/Delete")
    public void delete(@RequestBody Long id){
        Animal a=animalServiceImplementation.findFirstByIdAnimal(id);
        animalServiceImplementation.delete(a);
    }
    @PostMapping("/GetById")
    public ResponseEntity  findFirstByIdAnimal(@RequestBody Long id){
        Animal a=animalServiceImplementation.findFirstByIdAnimal(id);
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
    @PostMapping("/GetByNume")
    public ResponseEntity findFirstByNume(@RequestParam String nume){
        Animal a=animalServiceImplementation.findFirstByNume(nume);
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
//    @PostMapping("/GetByNumeAndPacientId")
//    public ResponseEntity findFirstByNumeAndPacientId(@RequestBody CautareAnimal cautareAnimal){
//        Animal a=animalServiceImplementation.findFirstByNumeAndPacient_IdPacient(cautareAnimal.getNume(),cautareAnimal.getIdPacient());
//        return ResponseEntity.status(HttpStatus.OK).body(a);
//    }
    @PostMapping("/AdaugaAnimal")
    public ResponseEntity insertAnimal(@RequestBody ConectareAnimal conectareAnimal){
        // Găsește pacientul pe baza id-ului
        Pacient p = pacientServiceImplementation.findFirstByIdPacient(conectareAnimal.getIdPacient());

        // Creează un nou animal și setează relația cu pacientul
        Animal anew = new Animal(conectareAnimal.getNume(), conectareAnimal.getRasa(), conectareAnimal.getVarsta(), conectareAnimal.getSex(), conectareAnimal.getSteril(), conectareAnimal.getNrCip(), conectareAnimal.getTipAnimal(), conectareAnimal.getIdPacient());
        // Inserează animalul
        animalServiceImplementation.insert(anew);
        // Adaugă animalul la lista de animale a pacientului
        p.getAnimale().add(anew);

        // Actualizează pacientul în baza de date
        pacientServiceImplementation.update(p);

        // Returnează animalul inserat
        Animal a = animalServiceImplementation.findFirstByIdAnimal(anew.getIdAnimal());
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
    @PostMapping("/UpdateAnimal")
    public ResponseEntity updateAnimal(@RequestBody UpdateAnimal updateAnimal){
       Animal a=animalServiceImplementation.findFirstByIdAnimal(updateAnimal.getIdAnimal());
       a.setNume(updateAnimal.getNume());
       a.setRasa(updateAnimal.getRasa());
       a.setVarsta(updateAnimal.getVarsta());
       a.setSex(updateAnimal.getSex());
       a.setSteril(updateAnimal.getSteril());
       a.setNrCip(updateAnimal.getNrCip());
       a.setTipAnimal(updateAnimal.getTipAnimal());
       a.setIdPacient(updateAnimal.getIdPacient());
       animalServiceImplementation.update(a);
       Animal afind=animalServiceImplementation.findFirstByIdAnimal(a.getIdAnimal());
       return ResponseEntity.status(HttpStatus.OK).body(afind);
    }
    @PostMapping("/GetByNumeAndIdPacient")
    public ResponseEntity findFirstByNumeAndPacientId(@RequestBody CautareAnimal cautareAnimal){
        Animal a=animalServiceImplementation.findFirstByNumeAndIdPacient(cautareAnimal.getNume(),cautareAnimal.getIdPacient());
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
    @PostMapping("/addFeedToAnimal")
    public ResponseEntity addFeedToAnimal(@RequestBody FeedbackAnimal feedbackAnimal){
        Animal a=animalServiceImplementation.findFirstByIdAnimal(feedbackAnimal.getIdAnimal());
        a.getFeedbacks().add(feedbackAnimal.getFeedback());
        animalServiceImplementation.update(a);
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
    @GetMapping("/All")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> animals = animalServiceImplementation.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(animals);
    }
    @PostMapping("/AddFeedAnimal")
    public ResponseEntity addFeed(@RequestBody AddAnimalFeed cautareAnimal)
    {
        Animal a=animalServiceImplementation.findFirstByNumeAndIdDoctor(cautareAnimal.getNume(),cautareAnimal.getIdPacient());
        a.getFeedbacks().add(cautareAnimal.getFeed());
        animalServiceImplementation.update(a);
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
    @PostMapping("/GetByNumeAndIdDoctor")
    public ResponseEntity findFirstByNumeAndDoctorId(@RequestBody CautareAnimal cautareAnimal){
        Animal a=animalServiceImplementation.findFirstByNumeAndIdDoctor(cautareAnimal.getNume(),cautareAnimal.getIdPacient());
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
}
