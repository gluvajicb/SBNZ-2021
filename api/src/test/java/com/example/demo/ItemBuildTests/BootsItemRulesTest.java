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
}
