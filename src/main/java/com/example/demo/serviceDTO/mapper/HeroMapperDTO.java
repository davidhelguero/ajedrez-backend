package com.example.demo.serviceDTO.mapper;

import com.example.demo.api.dto.HeroRequestDTO;
import com.example.demo.api.dto.HeroResponseDTO;
import com.example.demo.api.dto.PowerDTO;
import com.example.demo.serviceBO.bo.HeroBO;
import com.example.demo.serviceBO.bo.HeroPowerBO;
import com.example.demo.serviceBO.bo.PowerBO;
import com.example.demo.serviceBO.bo.WeaknessBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface HeroMapperDTO {

    @Mapping(target = "universe.code", source = "codeUniverse")
    @Mapping(target = "type.code", source = "codeType")
    @Mapping(target = "gender.code", source = "codeGender")
    @Mapping(target = "enemy.name", source = "enemy")
    @Mapping(target = "alterEgo.name", source = "alterEgo")
    @Mapping(target = "powers", source = "powers", qualifiedByName = "getPowersBO")
    @Mapping(target = "weaknesses", source = "weaknesses", qualifiedByName = "getWeaknesses")
    HeroBO heroDTOToHeroBO(HeroRequestDTO heroRequestDTO);

    @Mapping(target = "enemy", source = "enemy.name")
    @Mapping(target = "alterEgo", source = "alterEgo.name")
    @Mapping(target = "codeUniverse", source = "universe.code")
    @Mapping(target = "codeType", source = "type.code")
    @Mapping(target = "codeGender", source = "gender.code")
    @Mapping(target = "powers", source = "powers", qualifiedByName = "getPowersDTO")
    @Mapping(target = "weaknesses", source = "weaknesses", qualifiedByName = "getNamesWeaknesses")
    HeroRequestDTO heroBOToHeroDTO(HeroBO heroBO);

    @Mapping(target = "name", source = "name_hero")
    @Mapping(target = "alterEgo", source = "alterEgo.name")
    @Mapping(target = "enemy", source = "enemy.name")
    @Mapping(target = "powers", source = "powers", qualifiedByName = "getPowersDTO")
    @Mapping(target = "weaknesses", source = "weaknesses", qualifiedByName = "getNamesWeaknesses")
    HeroResponseDTO heroBOToHeroResponseDTO(HeroBO heroBO);

   @Named("getWeaknesses")
    default Set<WeaknessBO> getWeaknesses(Set<String> weaknesses) {
       if(weaknesses == null)
           return null;

       Set<WeaknessBO> weaknessBOS = new HashSet<>();

        for (String weakness : weaknesses) {
            WeaknessBO weaknessBO = new WeaknessBO();
            weaknessBO.setName(weakness);
            weaknessBOS.add(weaknessBO);
        }

        return weaknessBOS;
    }

    @Named("getNamesWeaknesses")
    default Set<String> getNamesWeaknesses(Set<WeaknessBO> weaknesses) {
       if(weaknesses == null)
           return null;
       Set<String> namesWeaknesses = new HashSet<>();

        for (WeaknessBO weakness : weaknesses) {
            namesWeaknesses.add(weakness.getName());
        }

        return namesWeaknesses;
    }

    @Named("getPowersBO")
    default Set<HeroPowerBO> getPowersBO(Set<PowerDTO> powers) {
        Set<HeroPowerBO> powersBO = new HashSet<>();

        for (PowerDTO power : powers) {
            HeroPowerBO heroPowerBO = new HeroPowerBO();
            PowerBO powerBO = new PowerBO();

            powerBO.setName(power.getName());
            heroPowerBO.setEvent(power.getEvent());
            heroPowerBO.setActive(true);
            heroPowerBO.setPower(powerBO);
            powersBO.add(heroPowerBO);
        }
        return powersBO;
    }

    @Named("getPowersDTO")
    default Set<PowerDTO> getPowersDTO(Set<HeroPowerBO> powers) {
        Set<PowerDTO> powersDTO = new HashSet<>();

        for (HeroPowerBO power : powers) {
            PowerDTO powerDTO = new PowerDTO();
            powerDTO.setName(power.getPower().getName());
            powerDTO.setEvent(power.getEvent());
            powerDTO.setActive(power.isActive());
            powersDTO.add(powerDTO);
        }

        return powersDTO;
    }
}
