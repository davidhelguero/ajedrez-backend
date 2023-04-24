package com.example.demo.serviceDTO.implementations;

import com.example.demo.api.dto.HeroRequestDTO;
import com.example.demo.api.dto.HeroResponseDTO;
import com.example.demo.serviceBO.bo.HeroBO;
import com.example.demo.serviceBO.interfaces.HeroServiceBO;
import com.example.demo.serviceDTO.mapper.HeroMapperDTO;
import com.example.demo.serviceDTO.interfaces.HeroServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HeroServiceDTOImp implements HeroServiceDTO {

    private final HeroServiceBO heroServiceBO;
    private final HeroMapperDTO heroMapperDTO;

    @Autowired
    public HeroServiceDTOImp(HeroServiceBO heroServiceBO, HeroMapperDTO heroMapperDTO) {
        this.heroServiceBO = heroServiceBO;
        this.heroMapperDTO = heroMapperDTO;
    }

    @Override
    public HeroRequestDTO add(HeroRequestDTO hero) throws Exception {
        //Validar lo que no se pueda resolver en una anotación. (formato)
        HeroBO heroBO = heroMapperDTO.heroDTOToHeroBO(hero);
        return heroMapperDTO.heroBOToHeroDTO(heroServiceBO.add(heroBO));
    }

    @Override
    public Set<HeroRequestDTO> getHeroes() {
        Set<HeroBO> heroes = heroServiceBO.getHeroes();

        return heroes.stream().parallel()
                .map(heroMapperDTO::heroBOToHeroDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<HeroResponseDTO> getHeroesByUniverse(String universe, String gender) {
        Set<HeroBO> heroes = heroServiceBO.getHeroesByUniverse(universe, gender);

        return heroes.stream().parallel()
                .map(heroMapperDTO::heroBOToHeroResponseDTO)
                .collect(Collectors.toSet());
    }


}
