package com.example.demo.Service;


import com.example.demo.Model.InfoStare;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InfoStareService {
    void insert(InfoStare infoStare);
    void update(InfoStare infoStare);
    void delete(InfoStare infoStare);
    InfoStare findFirstByIdInfo(Long id);
    List<InfoStare> findAllByIdAnimal(Long id);
}
