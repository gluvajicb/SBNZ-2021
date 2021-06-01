package com.example.demo.Model;

import com.example.demo.Model.Enums.ChampionClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

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

    @Column(name = "is_starting_item")
    private boolean isStartingItem;

    @Column(name = "for_classes")
    private String forClasses; // "ASSASSIN,MARKSMAN"

    @Column(name = "good_against_classes")
    private String goodAgainstClasses; // "ASSASSIN,MARKSMAN"




}
