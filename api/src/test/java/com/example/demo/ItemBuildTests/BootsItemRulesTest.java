package com.example.demo.ItemBuildTests;

import com.example.demo.Service.ChampionService;
import com.example.demo.Service.ItemService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BootsItemRulesTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ChampionService championService;
}
