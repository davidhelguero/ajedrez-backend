package com.example.demo.serviceBO.implementations;

import com.example.demo.api.dto.HeroRequestDTO;
import com.example.demo.api.dto.HeroResponseDTO;
import com.example.demo.data.entity.HeroDE;
import com.example.demo.serviceBO.bo.HeroBO;
import com.example.demo.serviceBO.bo.HeroPowerBO;
import com.example.demo.serviceBO.interfaces.*;
import com.example.demo.serviceBO.mapper.HeroMapperBO;
import com.example.demo.data.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HeroServiceBOImp implements HeroServiceBO {
    private final HeroRepository heroRepository;
    private final HeroMapperBO heroMapperBO;
    private final UniverseService universeService;
    private final TypeService typeService;
    private final GenderService genderService;
    private final PowerServiceBO powerServiceBO;


    @Autowired
    public HeroServiceBOImp(HeroRepository heroRepository, HeroMapperBO heroMapperBO, UniverseService universeService, TypeService typeService, GenderService genderService, PowerServiceBO powerServiceBO) {
        this.heroRepository = heroRepository;
        this.heroMapperBO = heroMapperBO;
        this.universeService = universeService;
        this.typeService = typeService;
        this.genderService = genderService;
        this.powerServiceBO = powerServiceBO;

    }

    @Override
    public Set<HeroBO> getHeroes() {
        List<HeroDE> heroesDE = heroRepository.findAll();
        Set<HeroDE> heroes = new HashSet<>(heroesDE);

        return heroes.stream().parallel()
                .map(heroMapperBO::heroDEToBO)
                .collect(Collectors.toSet());
    }

    @Override
    public HeroBO add(HeroBO hero) throws Exception {
        //VALIDACIONES DE NEGOCIO
        if(!heroRepository.findHeroByName(hero.getName_hero()).isEmpty())
            throw new RuntimeException("The hero already exists");

        hero.setUniverse(universeService.getUniverseByCode(hero.getUniverse().getCode()));
        hero.setType(typeService.getTypeByCode(hero.getType().getCode()));
        hero.setGender(genderService.getGenderByCode(hero.getGender().getCode()));

        //streams
        for (HeroPowerBO power : hero.getPowers()){
            power.setPower(powerServiceBO.getPowerByName(power.getPower().getName()));
        }

        HeroDE heroDE = heroMapperBO.heroBOToDE(hero);
        heroDE.getPowers().stream().peek(p -> p.setHero(heroDE)).collect(Collectors.toSet());

        return heroMapperBO.heroDEToBO(heroRepository.save(heroDE));
    }

    public void delete(Long id) {
        heroRepository.delete(getHeroById(id));
    }

    public HeroRequestDTO update(Long id, HeroRequestDTO hero) {
        HeroDE heroDE = getHeroById(id);
        heroDE.setName(hero.getName_hero());
        //heroDE.setPowers(hero.getPowers());
        //return heroMapper.heroDEToBO(heroRepository.save(heroDE));
        return null;
    }

    @Override
    public List<HeroResponseDTO> getHeroByName(String name) {
        return null;
    }

    @Override
    public Set<HeroBO> getHeroesByUniverse(String universe, String gender) {
        List<HeroDE> heroesDE = heroRepository.findByUniverseAndGender(universe, gender);
        Set<HeroDE> heroes = new HashSet<>(heroesDE);

        return heroes.stream().parallel()
                .map(heroMapperBO::heroDEToBO)
                .collect(Collectors.toSet());
    }

    /*@Override
    public List<HeroResponseDTO> getHeroByName(String name) {
        List<HeroDE> heroes = heroRepository.findHeroByName(name);

        return heroes.stream().parallel()
                .map(heroMapper::heroToHeroResponse)
                .collect(Collectors.toList());
    }*/

    private HeroDE getHeroById(Long id) {
        Optional<HeroDE> hero = heroRepository.findById(id);
        if (hero.isEmpty())
            throw new NullPointerException("The hero does not exist");
        return hero.get();
    }
}