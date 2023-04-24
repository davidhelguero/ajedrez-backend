package com.example.demo.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hero")
public class HeroDE{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_universe", referencedColumnName = "id")
    private UniverseDE universe;

    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    private TypeDE type;

    @ManyToOne
    @JoinColumn(name = "id_gender", referencedColumnName = "id")
    private GenderDE gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alterEgo_id", referencedColumnName = "id")
    private AlterEgoDE alterEgo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enemy_id", referencedColumnName = "id")
    private EnemyDE enemy;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hero")
    private Set<HeroPowerDE> powers;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "hero_weakness",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "weakness_id"))
    private Set<WeaknessDE> weaknesses;

}
