package com.example.demo.Controller;

import com.example.demo.Model.BuildRecommendAnswers;
import com.example.demo.Model.FullBuild;
import com.example.demo.Model.Item;
import com.example.demo.Model.ItemRecommendSession;
import com.example.demo.RulesHandler.BuildRecommendHandler;
import com.example.demo.Service.ChampionService;
import com.example.demo.Service.ItemService;
import com.example.demo.dto.BuildRecommenderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BuildRecommenderController {

    private final BuildRecommendHandler buildRecommendHandler;

    @Autowired
    public BuildRecommenderController(BuildRecommendHandler buildRecommendHandler) {
        this.buildRecommendHandler = buildRecommendHandler;

    }

    @PostMapping(value = "/build-recommender")
    public ResponseEntity<BuildRecommenderDTO> recommendBuild(@RequestBody BuildRecommendAnswers answers) {
        System.out.println(answers.toString());
        ItemRecommendSession irs = new ItemRecommendSession();
        buildRecommendHandler.buildRecommendRules(answers, irs);

        BuildRecommenderDTO fullBuildItems = new BuildRecommenderDTO(irs.getFullBuild().getStartingItem().getName(),
                                    irs.getFullBuild().getBoots().getName(),
                                    irs.getFullBuild().getMythicItem().getName(),
                                    irs.getFullBuild().getSituationalItem().getName(),
                                    irs.getFullBuild().getOffensiveItem().getName(),
                                    irs.getFullBuild().getDefensiveItem().getName());

        return new ResponseEntity<>(fullBuildItems, HttpStatus.OK);
    }


}
