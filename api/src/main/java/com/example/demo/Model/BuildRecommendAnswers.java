package com.example.demo.Model;


import com.example.demo.Model.Enums.Lane;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuildRecommendAnswers {

    private Lane pickedLane;
    private String pickedChampion;
    private String enemyChampionName;
    private String enemyChampionsList;
    private String earlyGamePlaystyle;

}
