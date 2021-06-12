package com.example.demo.Service;

import com.example.demo.Model.Champion;
import com.example.demo.Repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionService {

    @Autowired
    private ChampionRepository championRepository;

    public Champion getChampionByName(String name) {
        return championRepository.getChampionByName(name);
    }

    public List<Champion> getAllChampions() {
        return championRepository.findAll();
    }
    public void save(Champion ch){
        championRepository.save(ch);
    }
}
