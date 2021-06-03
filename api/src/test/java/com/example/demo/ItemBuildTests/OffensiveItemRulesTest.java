package com.example.demo.ItemBuildTests;

import com.example.demo.Model.*;
import com.example.demo.Model.Enums.ItemSlot;
import com.example.demo.Service.ChampionService;
import com.example.demo.Service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OffensiveItemRulesTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ChampionService championService;

    @Test
    public void testOffensiveItemMageAP() {
        //get all mythic items
        List<Item> items = itemService.findAllItemsByItemSlot(ItemSlot.OFFENSIVE);

        // set up our picked champion
        Champion pickedChamp = championService.getChampionByName("Malzahar");
        DamageType dt = new DamageType();

        dt.setMagicDamage(90);
        dt.setPhysicalDamage(10);
        pickedChamp.setDamageType(dt);

        //start a session for items recommender
        ItemRecommendSession irs = new ItemRecommendSession();
        FullBuild fb = new FullBuild();
        irs.setFullBuild(fb);

        irs.setPickedChampion(pickedChamp);

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("offensive-item-recommend-rules");

        // insert all the items into the session
        for(Item i: items) {
            System.out.println(i.toString());
            kSession.insert(i);
        }
        kSession.insert(irs);
        kSession.fireAllRules();

        // Rabadon's Deathcap is the mythic item that should be recommended because our picked champion is an AD assassin

        assertEquals("Void Staff", irs.getFullBuild().getOffensiveItem().getName());
    }

}
