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

    private Item offensiveItem;

    private Item defensiveItem;

    private Item situationalItem;
}
