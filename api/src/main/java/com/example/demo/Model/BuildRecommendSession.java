package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildRecommendSession {

    private Item startingItem;

    private Item mythicItem;

    private Item boots;

    private Item counterItem;

    private Item situationalItem1;

    private Item situationalItem2;
}
