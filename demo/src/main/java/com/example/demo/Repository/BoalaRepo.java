package com.example.demo.Repository;

import com.example.demo.Model.Boala;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoalaRepo  extends CrudRepository<Boala,Long> {
    Boala findFirstByBoalaId(Long id);
    //le faci alea noi din ce iti da el, nu scri de mana!!!!!!!!!!!!
    Boala findFirstByNumeBoala(String nume);
}
