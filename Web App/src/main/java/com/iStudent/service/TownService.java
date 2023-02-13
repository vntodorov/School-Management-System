package com.iStudent.service;

import com.iStudent.model.entity.Town;
import com.iStudent.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TownService {

    private final TownRepository townRepository;

    @Autowired
    public TownService(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    public Town findByTownName(String townName){
        return this.townRepository.findByName(townName).orElseThrow();
    }


}
