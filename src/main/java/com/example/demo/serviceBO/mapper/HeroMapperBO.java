package com.example.demo.serviceBO.mapper;

import com.example.demo.data.entity.HeroDE;
import com.example.demo.serviceBO.bo.HeroBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HeroMapperBO {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name_hero")
    @Mapping(target = "alterEgo.hero", ignore = true)
    @Mapping(target = "enemy.hero", ignore = true)
    HeroDE heroBOToDE(HeroBO heroBO);

    @Mapping(target = "name_hero", source = "name")
    HeroBO heroDEToBO(HeroDE heroDE);

}
