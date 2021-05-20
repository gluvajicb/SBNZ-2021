package com.example.demo.Model;

import com.example.demo.Model.Enums.*;
import com.example.demo.Model.Enums.Class;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private Class championClass;

    private Lane primaryLane;

    private Lane secondaryLane;

    @ManyToOne
    private DamageType damageType;

    private Range range;

    private Playstyle playstyle;

    private Strenght strenght;

    private AbilityResource abilityResource;

}
