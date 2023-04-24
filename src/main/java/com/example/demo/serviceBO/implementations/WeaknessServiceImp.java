package com.example.demo.serviceBO.implementations;

import com.example.demo.data.entity.WeaknessDE;
import com.example.demo.data.repository.WeaknessRepository;
import com.example.demo.serviceBO.bo.WeaknessBO;
import com.example.demo.serviceBO.interfaces.WeaknessService;
import com.example.demo.serviceBO.mapper.WeaknessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeaknessServiceImp implements WeaknessService {

    private final WeaknessRepository weaknessRepository;
    private final WeaknessMapper weaknessMapper;

    @Autowired
    public WeaknessServiceImp(WeaknessRepository weaknessRepository, WeaknessMapper weaknessMapper) {
        this.weaknessRepository = weaknessRepository;
        this.weaknessMapper = weaknessMapper;
    }

    @Override
    public WeaknessBO getWeaknessByName(String name) {
        if(name == null)
            return null;
        Optional<WeaknessDE> weakness = Optional.ofNullable(weaknessRepository.findByName(name));
        if(weakness.isEmpty())
            throw new RuntimeException(name + " do not exists");
        return weaknessMapper.weaknessDEToBO(weakness.get());
    }
}
