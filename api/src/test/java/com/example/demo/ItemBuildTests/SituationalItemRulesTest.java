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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SituationalItemRulesTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ChampionService championService;

    @Test
    public void testSituationalEnemyAssassin() {
        ItemRecommendSession irs = new ItemRecommendSession();
        FullBuild fb = new FullBuild();

        //load all situational items
        List<Item> items = itemService.findAllItemsByItemSlot(ItemSlot.SITUATIONAL);
        Champion pickedChamp = championService.getChampionByName("Malzahar");
        DamageType dt = new DamageType();

        dt.setMagicDamage(90);
        dt.setPhysicalDamage(10);
        pickedChamp.setDamageType(dt);

        // set up enemy champion
        Champion enemyChampMain = championService.getChampionByName("Zed");
        DamageType dt1 = new DamageType();
        dt1.setPhysicalDamage(90); dt1.setMagicDamage(10);
        enemyChampMain.setDamageType(dt1);
        irs.setEnemyChampion(enemyChampMain);

        // set up an item recommending session and its parameters
        irs.setFullBuild(fb);
        irs.setPickedChampion(pickedChamp);

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("situational-item-recommend-rules");

        // insert all the items into the session
        for(Item i: items) {
            System.out.println(i.toString());

            kSession.insert(i);
        }
        // insert item recommending session in which we track already recommended items
        kSession.insert(irs);

        kSession.fireAllRules();

        // Zhonya's Hourglass is the item that should be recommended because its good against selected enemy champion
        assertEquals("Zhonya's Hourglass", irs.getFullBuild().getSituationalItem().getName());
    }

    @Test
    public void testSituationalEnemyTank() {
        //get all boots items
        List<Item> items = itemService.findAllItemsByItemSlot(ItemSlot.SITUATIONAL);
        Champion pickedChamp = championService.getChampionByName("Zed");
        DamageType dt = new DamageType();

        dt.setMagicDamage(10);
        dt.setPhysicalDamage(90);
        pickedChamp.setDamageType(dt);

        // set up enemy champion
        Champion enemyChampMain = championService.getChampionByName("Sion");
        DamageType dt1 = new DamageType();
        dt1.setPhysicalDamage(80); dt.setMagicDamage(20);
        enemyChampMain.setDamageType(dt1);

        // set up an item recommending session and its parameters
        ItemRecommendSession irs = new ItemRecommendSession();
        FullBuild fb = new FullBuild();
        irs.setFullBuild(fb);

        irs.setPickedChampion(pickedChamp);
        // set up a champion we are playing directly against
        irs.setEnemyChampion(enemyChampMain);

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("situational-item-recommend-rules");

        // insert all the items into the session
        for(Item i: items) {
            System.out.println(i.toString());

            kSession.insert(i);
        }
        kSession.insert(irs);

        kSession.fireAllRules();

        // Lord Dominik's Regards is the item that should be recommended because its good in countering the enemy champion
        assertEquals("Lord Dominik's Regards", irs.getFullBuild().getSituationalItem().getName());
    }
}
