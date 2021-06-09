package com.example.demo.Controller;

import com.example.demo.Model.BuildRecommendAnswers;
import com.example.demo.Model.FullBuild;
import com.example.demo.Model.Item;
import com.example.demo.Model.ItemRecommendSession;
import com.example.demo.RulesHandler.BuildRecommendHandler;
import com.example.demo.Service.ChampionService;
import com.example.demo.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildRecommenderController {

    private final BuildRecommendHandler buildRecommendHandler;

    @Autowired
    public BuildRecommenderController(BuildRecommendHandler buildRecommendHandler) {
        this.buildRecommendHandler = buildRecommendHandler;

    }

    @PostMapping(value = "/build-recommender")
    public ResponseEntity<FullBuild> recommendBuild(@RequestBody BuildRecommendAnswers answers) {
        ItemRecommendSession irs = new ItemRecommendSession();
        buildRecommendHandler.buildRecommendRules(answers, irs);

        return new ResponseEntity<>(irs.getFullBuild(), HttpStatus.OK);
    }


}
