package com.example.demo.serviceBO.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroBO {

    private String name_hero;
    private AlterEgoBO alterEgo;
    private EnemyBO enemy;
    private GenderBO gender;
    private TypeBO type;
    private UniverseBO universe;
    private Set<HeroPowerBO> powers;
    private Set<WeaknessBO> weaknesses;
}
