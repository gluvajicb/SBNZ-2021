package com.example.demo.Model;

import javax.persistence.*;

@Entity
public class DamageType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int magicDamage;
    private int physicalDamage;
    private int trueDamage;

    @OneToMany
    private Champion champion;
}
