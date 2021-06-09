package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class DamageType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int magicDamage;
    private int physicalDamage;

    @OneToMany
    private List<Champion> champion;

    public DamageType(int magicDamage, int physicalDamage) {
        this.magicDamage = magicDamage;
        this.physicalDamage = physicalDamage;
    }
}
