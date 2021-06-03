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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BootsItemRulesTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ChampionService championService;

    @Test
    public void testBootsEnemyHeavyAD() {
//get all starting items
        List<Item> items = itemService.findAllItemsByItemSlot(ItemSlot.BOOTS);
        Champion pickedChamp = championService.getChampionByName("Zed");
        DamageType dt = new DamageType();
        //
        dt.setMagicDamage(1);
        dt.setPhysicalDamage(99);
        pickedChamp.setDamageType(dt);



// set enemy champions
        Champion enemyChampMain = championService.getChampionByName("Zed");
        DamageType dt1 = new DamageType();
        dt1.setPhysicalDamage(90); dt1.setMagicDamage(10);
        enemyChampMain.setDamageType(dt1);

        Champion enemyChampion2 = championService.getChampionByName("Soraka");
        DamageType dt2 = new DamageType();
        dt2.setMagicDamage(90); dt2.setPhysicalDamage(10);
        enemyChampion2.setDamageType(dt2);

        Champion enemyChampion3 = championService.getChampionByName("Sion");
        DamageType dt3 = new DamageType();
        dt3.setMagicDamage(20); dt3.setPhysicalDamage(80);
        enemyChampion3.setDamageType(dt3);

        Champion enemyChampion4 = championService.getChampionByName("Jhin");
        DamageType dt4 = new DamageType();
        dt4.setMagicDamage(0); dt4.setPhysicalDamage(100);
        enemyChampion4.setDamageType(dt4);

        Champion enemyChampion5 = championService.getChampionByName("Kindred");
        DamageType dt5 = new DamageType();
        dt5.setMagicDamage(10); dt5.setPhysicalDamage(90);
        enemyChampion5.setDamageType(dt5);
//start a session for starting items
        ItemRecommendSession irs = new ItemRecommendSession();
        FullBuild fb = new FullBuild();
        irs.setFullBuild(fb);

        irs.setPickedChampion(pickedChamp);
        irs.setEnemyChampion(enemyChampMain);
        List<Champion> enemyChamps = new ArrayList<>();
        enemyChamps.add(enemyChampion2);
        enemyChamps.add(enemyChampion3);
        enemyChamps.add(enemyChampion4);
        enemyChamps.add(enemyChampion5);
        enemyChamps.add(enemyChampMain);

        irs.setAllEnemyChampions(enemyChamps);



        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("boots-recommend-rules");

        // insert all the items into the session
        for(Item i: items) {
            System.out.println(i.toString());

            kSession.insert(i);
        }
        //insert our current item recommend session
        kSession.insert(irs);

        kSession.fireAllRules();

        // Dorans Ring is the item that should be recommended

        assertEquals("Plated Steelcaps", irs.getFullBuild().getBoots().getName());
    }

    @Test
    public void testBootsPickedLaneSupport() {
//get all starting items
        List<Item> items = itemService.findAllItemsByItemSlot(ItemSlot.BOOTS);
        Champion pickedChamp = championService.getChampionByName("Soraka");
        DamageType dt = new DamageType();
        //
        dt.setMagicDamage(90);
        dt.setPhysicalDamage(10);
        pickedChamp.setDamageType(dt);

//start a session for starting items
        ItemRecommendSession irs = new ItemRecommendSession();
        FullBuild fb = new FullBuild();
        irs.setFullBuild(fb);

        irs.setPickedChampion(pickedChamp);
        irs.setPickedLane(Lane.SUPPORT);

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("boots-recommend-rules");
        kSession.getAgenda().getAgendaGroup("support").setFocus();

        // insert all the items into the session
        for(Item i: items) {
            kSession.insert(i);
        }
        //insert our current item recommend session
        kSession.insert(irs);
        kSession.fireAllRules();

        // Dorans Ring is the item that should be recommended

        assertEquals("Mobility Boots", irs.getFullBuild().getBoots().getName());
    }

    @Test
    public void testBootsPickedChampionAD() {
//get all starting items
        List<Item> items = itemService.findAllItemsByItemSlot(ItemSlot.BOOTS);
        Champion pickedChamp = championService.getChampionByName("Zed");
        DamageType dt = new DamageType();
        //
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
        KieSession kSession = kc.newKieSession("boots-recommend-rules");

        // insert all the items into the session
        for(Item i: items) {
            kSession.insert(i);
        }
        //insert our current item recommend session
        kSession.insert(irs);
        kSession.fireAllRules();

        // Dorans Ring is the item that should be recommended

        assertEquals("Berserker's Greaves", irs.getFullBuild().getBoots().getName());
    }
}
