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
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MythicItemRulesTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ChampionService championService;

    @Test
    public void testMythicItemForAssassinAD() {
        //get all mythic items
        List<Item> items = itemService.findAllItemsByItemSlot(ItemSlot.MYTHIC);

        // set up our picked champion
        Champion pickedChamp = championService.getChampionByName("Zed");
        DamageType dt = new DamageType();

        dt.setMagicDamage(1);
        dt.setPhysicalDamage(99);
        pickedChamp.setDamageType(dt);

       //start a session for items recommender
        ItemRecommendSession irs = new ItemRecommendSession();
        FullBuild fb = new FullBuild();
        irs.setFullBuild(fb);

        irs.setPickedChampion(pickedChamp);

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("mythic-item-recommend-rules");

        // insert all the items into the session
        for(Item i: items) {
            System.out.println(i.toString());
            kSession.insert(i);
        }
        kSession.insert(irs);
        kSession.fireAllRules();

        // Duskblade of Draktharr is the mythic item that should be recommended because our picked champion is an AD assassin

        assertEquals("Duskblade of Draktharr", irs.getFullBuild().getMythicItem().getName());
    }

    @Test
    public void testMythicItemForSupportAP() {
        //get all mythic items
        List<Item> items = itemService.findAllItemsByItemSlot(ItemSlot.MYTHIC);

        // set up our picked champion
        Champion pickedChamp = championService.getChampionByName("Soraka");
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
        KieSession kSession = kc.newKieSession("mythic-item-recommend-rules");

        // insert all the items into the session
        for(Item i: items) {
            System.out.println(i.toString());
            kSession.insert(i);
        }
        kSession.insert(irs);
        kSession.fireAllRules();

        // Locket of the Iron Solari is the mythic item that should be recommended because our picked champion an ap support

        assertEquals("Locket of the Iron Solari", irs.getFullBuild().getMythicItem().getName());
    }
}
