package com.example.demo.Model;

import com.example.demo.Model.Enums.ChampionClass;
import com.example.demo.Model.Enums.ItemSlot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "is_offensive")
    private boolean isOffensive;

    @Column(name = "is_defensive")
    private boolean isDefensive;

    @Column(name = "is_for_ap")
    private boolean isForAP;

    @Column(name = "is_for_ad")
    private boolean isForAD;

    @Column(name = "is_armor")
    private boolean isArmor;

    @Column(name = "is_magic_resist")
    private boolean isMagicResist;

    @Column(name = "item_slot")
    private ItemSlot itemSlot;

    @Column(name = "for_class")
    private ChampionClass forClass; // "ASSASSIN,MARKSMAN"

    @Column(name = "good_against_class")
    private ChampionClass goodAgainstClass; // "ASSASSIN,MARKSMAN"




}
