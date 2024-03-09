package com.example.demo.Controller;

import com.example.demo.DTO.NewInfo;
import com.example.demo.Model.Animal;
import com.example.demo.Model.Doctor;
import com.example.demo.Model.InfoStare;
import com.example.demo.Service.Implementation.AnimalServiceImplementation;
import com.example.demo.Service.Implementation.InfoStareServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/InfoStare")
public class InfoStareController {
    private final InfoStareServiceImplementation infoStareServiceImplementation;
    private final AnimalServiceImplementation animalServiceImplementation;
    @PostMapping("/Insert")
    public ResponseEntity insert(@RequestBody InfoStare infoStare){
        infoStareServiceImplementation.insert(infoStare);
        InfoStare d= infoStareServiceImplementation.findFirstByIdInfo(infoStare.getIdInfo());
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }
    @PostMapping("/Update")
    public void update(@RequestBody InfoStare infoStare){
        infoStareServiceImplementation.update(infoStare);
    }
    @PostMapping("/Delete")
    public void delete(@RequestBody Long id){
        InfoStare d= infoStareServiceImplementation.findFirstByIdInfo(id);
        infoStareServiceImplementation.delete(d);
    }
    @PostMapping("/AllById")
    public ResponseEntity<List<InfoStare>> getAllInfos(@RequestBody Long id) {
        List<InfoStare> infos = infoStareServiceImplementation.findAllByIdAnimal(id);
        return ResponseEntity.status(HttpStatus.OK).body(infos);
    }
    @PostMapping("/InsertInfoStare")
    public ResponseEntity insertInfo(@RequestBody NewInfo infoStare){
        Animal a = animalServiceImplementation.findFirstByIdAnimal(infoStare.getIdAnimal());
        System.out.println("animalul obj: "+a);
        InfoStare i=new InfoStare(infoStare.getStare(), infoStare.getDetalii(),infoStare.getIdAnimal());
        if (a != null) {
            a.getIstoric().add(i);
            animalServiceImplementation.update(a);
            infoStareServiceImplementation.insert(i);
            //System.out.println("animalul obj: "+a);
            return ResponseEntity.status(HttpStatus.OK).body(a);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("select an valid id");
        }
    }
}
