package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String name;

    private boolean isOffensive;

    private boolean isForAP;

    private boolean isForAD;

    private boolean isStartingItem;


}
