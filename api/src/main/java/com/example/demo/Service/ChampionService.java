package com.example.demo.Service;

import com.example.demo.Model.Champion;
import com.example.demo.Repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampionService {

    @Autowired
    private ChampionRepository championRepository;

    public Champion getChampionByName(String name) {
        return championRepository.getChampionByName(name);
    }
}
