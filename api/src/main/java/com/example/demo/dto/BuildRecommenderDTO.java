package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class BuildRecommenderDTO {

    private String startingItem;
    private String boots;
    private String mythicItem;
    private String situationalItem;
    private String defensiveItem;
    private String offensiveItem;

    public BuildRecommenderDTO(String startingItem, String boots, String mythicItem, String situationalItem,String offensiveItem,  String defensiveItem) {
        this.startingItem = startingItem;
        this.boots = boots;
        this.mythicItem = mythicItem;
        this.situationalItem = situationalItem;
        this.offensiveItem = offensiveItem;
        this.defensiveItem = defensiveItem;
    }

}
