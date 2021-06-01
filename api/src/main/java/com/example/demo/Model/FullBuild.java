package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullBuild {

    private Item startingItem;

    private Item mythicItem;

    private Item boots;

    private Item offensiveItem; //
                                // ova dva itema idu jedan za drugim, ako imaju puno ad uzima se def item
    private Item defensiveItem; //

    private Item situationalItem; // dobar protiv protivnickog heroja na lejnu
}
