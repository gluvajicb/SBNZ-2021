package com.example.demo.ItemBuildTests;

import com.example.demo.Model.*;
import com.example.demo.Model.Enums.ItemSlot;
import com.example.demo.Model.Enums.Lane;
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
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StartingItemRulesTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ChampionService championService;

    @Test
    public void testStartingItemOffensiveAP() {
        //get all starting items
        List<Item> items = itemService.findAllItemsByItemSlot(ItemSlot.STARTING);
        Champion pickedChamp = championService.getChampionByName("Malzahar");

        //setujem dmg type jer jos nemamo damage type u bazi
        DamageType dt = new DamageType();
        dt.setMagicDamage(90);
        dt.setPhysicalDamage(10);
        pickedChamp.setDamageType(dt);

        //start a session for starting items

        ItemRecommendSession irs = new ItemRecommendSession();
        FullBuild fb = new FullBuild();
        irs.setFullBuild(fb);

        irs.setPickedChampion(pickedChamp);

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("starting-item-recommend-rules");
        kSession.getAgenda().getAgendaGroup("offensive").setFocus();

        // insert all the items into the session
        for(Item i: items) {
            kSession.insert(i);
        }
        //insert our current item recommend session
        kSession.insert(irs);

        kSession.fireAllRules();

        // Dorans Ring is the item that should be recommended

        assertEquals("Doran's Ring", irs.getFullBuild().getStartingItem().getName());
    }

    @Test
    public void testStartingItemOffensiveAD() {
        //get all starting items
        List<Item> items = itemService.findAllItemsByItemSlot(ItemSlot.STARTING);
        Champion pickedChamp = championService.getChampionByName("Zed");
        DamageType dt = new DamageType();
        //setujem dmg type jer jos nemamo damage type u bazi
        dt.setMagicDamage(1);
        dt.setPhysicalDamage(99);
        pickedChamp.setDamageType(dt);
        //start a session for starting items

        ItemRecommendSession irs = new ItemRecommendSession();
        FullBuild fb = new FullBuild();
        irs.setFullBuild(fb);

        irs.setPickedChampion(pickedChamp);

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("starting-item-recommend-rules");
        kSession.getAgenda().getAgendaGroup("offensive").setFocus();

        // insert all the items into the session
        for(Item i: items) {
            System.out.println(i.toString());

            kSession.insert(i);
        }
        //insert our current item recommend session
        kSession.insert(irs);

        kSession.fireAllRules();

        // Dorans Ring is the item that should be recommended

        assertEquals("Doran's Blade", irs.getFullBuild().getStartingItem().getName());
    }

    @Test
    public void testStartingItemSupport() {
        //get all starting items
        List<Item> items = itemService.findAllItemsByItemSlot(ItemSlot.STARTING);
        Champion pickedChamp = championService.getChampionByName("Soraka");
        DamageType dt = new DamageType();
        //setujem dmg type jer jos nemamo damage type u bazi
        dt.setMagicDamage(90);
        dt.setPhysicalDamage(10);
        pickedChamp.setDamageType(dt);
        //start a session for starting items

        ItemRecommendSession irs = new ItemRecommendSession();
        // set lane to SUPPORT since that is what we are testing
        irs.setPickedLane(Lane.SUPPORT);

        FullBuild fb = new FullBuild();
        irs.setFullBuild(fb);

        irs.setPickedChampion(pickedChamp);

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("starting-item-recommend-rules");
        kSession.getAgenda().getAgendaGroup("support").setFocus();

        // insert all the items into the session
        for(Item i: items) {
            kSession.insert(i);
        }
        //insert our current item recommend session
        kSession.insert(irs);

        kSession.fireAllRules();

        // Spellthief's Edge is the item that should be recommended

        assertEquals("Spellthief's Edge", irs.getFullBuild().getStartingItem().getName());
    }
}
