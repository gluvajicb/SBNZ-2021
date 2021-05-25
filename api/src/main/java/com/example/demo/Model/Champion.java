package com.example.demo.Model;

import com.example.demo.Model.Enums.*;
import com.example.demo.Model.Enums.ChampionClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "champions")
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "primary_class")
    private ChampionClass primaryClass;

    @Column(name = "secondary_class")
    private ChampionClass secondaryClass;

    @Column(name = "primary_lane")
    private Lane primaryLane;

    @Column(name = "secondary_lane")
    private Lane secondaryLane;

    @ManyToOne
    private DamageType damageType;

    @Column(name = "attack_range")
    private Range attackRange;

    @Column(name = "playstyle")
    private Playstyle playstyle;

    @Column(name = "strenght")
    private Strenght strenght;

    @Column(name = "ability_resource")
    private AbilityResource abilityResource;

}
