package com.example.demo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroRequestDTO {

    @NotBlank(message = "Enter a name")
    @Pattern(regexp = "\\D*", message = "The name cannot have numbers")
    private String name_hero;
    private String alterEgo;
    private String enemy;
    private String codeUniverse;
    private String codeType;
    private String codeGender;
    private Set<PowerDTO> powers;
    private Set<String> weaknesses;
}
