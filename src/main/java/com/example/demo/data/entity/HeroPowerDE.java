package com.example.demo.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hero_power")
public class HeroPowerDE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    private HeroDE hero;

    @ManyToOne
    @JoinColumn(name = "power_id")
    private PowerDE power;

    private String event;
    private boolean active;
}
