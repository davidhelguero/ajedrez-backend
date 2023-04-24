package com.example.demo.serviceDTO.interfaces;

import com.example.demo.api.dto.HeroRequestDTO;
import com.example.demo.api.dto.HeroResponseDTO;

import java.util.Set;

public interface HeroServiceDTO {

    HeroRequestDTO add(HeroRequestDTO hero) throws Exception;

    Set<HeroRequestDTO> getHeroes();

    Set<HeroResponseDTO> getHeroesByUniverse(String universe, String gender);
}
