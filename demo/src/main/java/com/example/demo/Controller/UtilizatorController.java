package com.example.demo.Controller;

import com.example.demo.DTO.Conectare;
import com.example.demo.Model.Utilizator;
import com.example.demo.Service.Implementation.UtilizatorServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//se ocupa cu ce imi vine de la interfata
@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/Utilizator")
public class UtilizatorController {
    private final UtilizatorServiceImplementation utilizatorServiceImplementation;
    @PostMapping("/Insert")
    public ResponseEntity insert(@RequestBody Utilizator utilizator){
        utilizatorServiceImplementation.insert(utilizator);
        Utilizator u=utilizatorServiceImplementation.findFirstByUtilizatorId(utilizator.getUtilizatorId());
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }
    @PostMapping("/Update")
    public void update(@RequestBody Utilizator utilizator){
        utilizatorServiceImplementation.update(utilizator);
    }
    @PostMapping("/Delete")
    public void delete(@RequestParam Long id){
        Utilizator u=utilizatorServiceImplementation.findFirstByUtilizatorId(id);
        utilizatorServiceImplementation.delete(u);
    }
    @PostMapping("/GetById")
    public ResponseEntity findByUtilizatorId(@RequestParam Long id){
        Utilizator u=utilizatorServiceImplementation.findFirstByUtilizatorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }
    @PostMapping("/GetByEmailAndParola")
    public ResponseEntity findByEmailAndParola(@RequestParam String email,@RequestParam String parola){
        Utilizator u=utilizatorServiceImplementation.findFirstByEmailAndParola(email,parola);
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }
    @PostMapping("/GetByNumeAndPrenume")
    public ResponseEntity findByNumeAndPrenume(@RequestParam String nume,@RequestParam String prenume){
        Utilizator u=utilizatorServiceImplementation.findFirstByEmailAndParola(nume,prenume);
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }

    @PostMapping("/GetByEmailAndParola2")
    public ResponseEntity getByEmailAndParola(@RequestBody Conectare conectare){
        Utilizator u=utilizatorServiceImplementation.findFirstByEmailAndParola(conectare.getEmail(), conectare.getParola());
        if(u!=null)
            return ResponseEntity.status(HttpStatus.OK).body(u);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("You need to create an account");
    }
}
