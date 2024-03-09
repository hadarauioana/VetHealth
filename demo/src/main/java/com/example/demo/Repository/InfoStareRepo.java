package com.example.demo.Repository;


import com.example.demo.Model.InfoStare;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoStareRepo extends CrudRepository<InfoStare,Long> {
    InfoStare findFirstByIdInfo(Long id);
    List<InfoStare> findAllByIdAnimal(Long id);
}
