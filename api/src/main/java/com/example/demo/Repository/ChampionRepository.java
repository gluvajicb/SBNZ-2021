package com.example.demo.Repository;

import com.example.demo.Model.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long> {

    Champion getChampionByName(String name);

}
