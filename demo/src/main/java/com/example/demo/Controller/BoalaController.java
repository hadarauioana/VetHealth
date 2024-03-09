package com.example.demo.Controller;
import com.example.demo.DTO.Conectare;
import com.example.demo.DTO.ConectareBoala;
import com.example.demo.DTO.CreareCont;
import com.example.demo.DTO.InserareBoala;
import com.example.demo.Model.Boala;
import com.example.demo.Model.Pacient;
import com.example.demo.Model.Utilizator;
import com.example.demo.Service.Implementation.BoalaServiceImplementation;
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
@RequestMapping("/Boala")
public class BoalaController {
    private final BoalaServiceImplementation boalaServiceImplementation;
    @PostMapping("/Insert")
    public ResponseEntity insert(@RequestBody Boala boala){
        boalaServiceImplementation.insert(boala);
        Boala b=boalaServiceImplementation.findFirstByBoalaId(boala.getBoalaId());
        return ResponseEntity.status(HttpStatus.OK).body(b);
    }
    @PostMapping("/Update")
    public void update(@RequestBody Boala boala){
        boalaServiceImplementation.update(boala);
    }
    @PostMapping("/Delete")
    public void delete(@RequestParam Long id){
        Boala b=boalaServiceImplementation.findFirstByBoalaId(id);
        boalaServiceImplementation.delete(b);
    }
    @PostMapping("/GetByNumeBoala")
    public ResponseEntity getByNumeBoala(@RequestBody ConectareBoala conectareBoala){
        Boala b=boalaServiceImplementation.findFirstByNumeBoala(conectareBoala.getNumeBoala());
        return ResponseEntity.status(HttpStatus.OK).body(b);
    }
    @PostMapping("/InserareBoala")
    public ResponseEntity insertBoala(@RequestBody InserareBoala inserareBoala){
        Boala b=new Boala(inserareBoala.getNumeBoala(),inserareBoala.getDescriereBoala());
        boalaServiceImplementation.insert(b);
        return ResponseEntity.status(HttpStatus.OK).body(b);
    }

}
