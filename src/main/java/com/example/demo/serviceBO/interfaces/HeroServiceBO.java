package com.example.demo.serviceBO.interfaces;

import java.util.List;
import java.util.Set;

import com.example.demo.api.dto.HeroRequestDTO;
import com.example.demo.api.dto.HeroResponseDTO;
import com.example.demo.serviceBO.bo.HeroBO;


public interface HeroServiceBO {
    Set<HeroBO> getHeroes();

    HeroBO add(HeroBO hero) throws Exception;

    void delete(Long id);

    HeroRequestDTO update(Long id, HeroRequestDTO hero);

    List<HeroResponseDTO> getHeroByName(String name);

    Set<HeroBO> getHeroesByUniverse(String universe, String gender);
}
