package com.example.demo.serviceBO.implementations;

import com.example.demo.api.dto.PowerResponseDTO;
import com.example.demo.data.entity.HeroDE;
import com.example.demo.data.entity.PowerDE;
import com.example.demo.data.repository.PowerRepository;
import com.example.demo.serviceBO.bo.PowerBO;
import com.example.demo.serviceBO.interfaces.PowerServiceBO;
import com.example.demo.serviceBO.mapper.PowerMapperBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PowerServiceBOImp implements PowerServiceBO {

    private final PowerRepository powerRepository;
    private final PowerMapperBO powerMapperBO;

    @Autowired
    public PowerServiceBOImp(PowerRepository powerRepository, PowerMapperBO powerMapperBO) {
        this.powerRepository = powerRepository;
        this.powerMapperBO = powerMapperBO;
    }

    @Override
    public PowerBO addPower(PowerBO powerBO) {
        if(exists(powerBO.getName())) throw new RuntimeException("The power already exists");
        powerBO.setActive(true);
        return powerMapperBO.powerDEToBO(powerRepository.save(powerMapperBO.powerBOToDE(powerBO)));
    }

    @Override
    public List<PowerBO> getPowers() {
        List<PowerDE> powers = powerRepository.findByActiveTrue();

        return powers.stream().parallel()
                .map(powerMapperBO::powerDEToBO)
                .collect(Collectors.toList());
    }

    @Override
    public PowerBO getPowerByName(String name) {
        if(name  == null)
            return null;
        return powerMapperBO.powerDEToBO(getPower(name));
    }

    @Override
    public PowerBO updatePower(String name, PowerBO powerBO) {
        PowerDE power = getPower(name);
        power.setName(powerBO.getName());
        return powerMapperBO.powerDEToBO(powerRepository.save(power));
    }

    @Override
    public void deletePower(String name) {
        PowerDE power = getPower(name);
        power.setActive(false);
        powerRepository.save(power);
    }

    PowerDE getPower(String name){
        Optional<PowerDE> power = Optional.ofNullable(powerRepository.findPowerByName(name));
        if(power.isEmpty())
            throw new NullPointerException(name + " does not exist");
        return power.get();
    }

    Boolean exists(String name){
        Optional<PowerDE> power = Optional.ofNullable(powerRepository.findPowerByName(name));
        return power.isPresent();
    }
}
