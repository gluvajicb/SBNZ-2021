package com.example.demo;

import com.example.demo.ChampionRecommendTests.ClassRulesTests;
import com.example.demo.ItemBuildTests.*;
import com.example.demo.Model.Enums.AbilityResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StartingItemRulesTest.class, BootsItemRulesTest.class, MythicItemRulesTest.class, SituationalItemRulesTest.class, DefensiveItemRulesTest.class, OffensiveItemRulesTest.class,
})
public class SuiteAll {
}
