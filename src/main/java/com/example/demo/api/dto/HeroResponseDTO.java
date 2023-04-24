package com.example.demo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroResponseDTO {

    private String name;
    private String alterEgo;
    private String enemy;
    private GenderDTO gender;
    private TypeDTO type;
    private UniverseDTO universe;
    private Set<PowerDTO> powers;
    private Set<String> weaknesses;
}
