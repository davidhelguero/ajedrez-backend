package com.example.demo.serviceBO.mapper;

import com.example.demo.api.dto.PowerDTO;
import com.example.demo.serviceBO.bo.HeroPowerBO;
import com.example.demo.serviceBO.bo.PowerBO;
import com.example.demo.serviceBO.bo.WeaknessBO;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UtilMapper {

    @Named("getWeaknesses")
    public Set<WeaknessBO> getWeaknesses(Set<String> weaknesses) {
        Set<WeaknessBO> weaknessBOS = new HashSet<>();

        for (String weakness : weaknesses) {
            WeaknessBO weaknessBO = new WeaknessBO();
            weaknessBO.setName(weakness);
            weaknessBOS.add(weaknessBO);
        }

        return weaknessBOS;
    }

    @Named("getNamesWeaknesses")
    public Set<String> getNamesWeaknesses(Set<WeaknessBO> weaknesses) {
        Set<String> namesWeaknesses = new HashSet<>();

        for (WeaknessBO weakness : weaknesses) {
            namesWeaknesses.add(weakness.getName());
        }

        return namesWeaknesses;
    }

    @Named("getPowersBO")
    public Set<HeroPowerBO> getPowersBO(Set<PowerDTO> powers) {
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
    public Set<PowerDTO> getPowersDTO(Set<HeroPowerBO> powers) {
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












/*
@Named("getPowersResponse")
    public Set<PowerDTO> getPowers2(Set<HeroPowerDE> powersDE) {
        Set<PowerDTO> powersDTO = new HashSet<>();

        for (HeroPowerDE power : powersDE) {
            PowerDTO powerDTO = new PowerDTO();
            powerDTO.setName(power.getPower().getName());
            powerDTO.setEvent(power.getEvent());
            powerDTO.setActive(power.isActive());
            powersDTO.add(powerDTO);
        }
        return powersDTO;
    }
*/

/*
@Named("getNameWeaknesses")
    public Set<String> getNameWeaknesses(Set<WeaknessDE> weaknesses) {
        Set<String> nameWeakness = new HashSet<>();

        for (WeaknessDE weakness : weaknesses) {
            nameWeakness.add(weakness.getName());
        }

        return nameWeakness;
    }
 */