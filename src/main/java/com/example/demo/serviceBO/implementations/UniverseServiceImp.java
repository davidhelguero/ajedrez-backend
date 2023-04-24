package com.example.demo.serviceBO.implementations;

import com.example.demo.data.entity.GenderDE;
import com.example.demo.data.entity.UniverseDE;
import com.example.demo.data.repository.UniverseRepository;
import com.example.demo.serviceBO.bo.UniverseBO;

import com.example.demo.serviceBO.interfaces.UniverseService;
import com.example.demo.serviceBO.mapper.UniverseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UniverseServiceImp implements UniverseService {

    private final UniverseRepository universeRepository;
    private final UniverseMapper universeMapper;

    @Autowired
    public UniverseServiceImp(UniverseRepository universeRepository, UniverseMapper universeMapper) {
        this.universeRepository = universeRepository;
        this.universeMapper = universeMapper;
    }

    @Override
    public UniverseBO getUniverseByCode(String code) {
        if(code == null)
            return null;
        Optional<UniverseDE> universe = Optional.ofNullable(universeRepository.getUniverseByCode(code));
        if(universe.isEmpty())
            throw new NullPointerException("The universe does not exist");
        return universeMapper.universeDEToBO(universe.get());

    }

    @Override
    public UniverseDE getUniverseByName(String name) {
        Optional<UniverseDE> universe = Optional.ofNullable(universeRepository.findFirstByName(name));
        if(universe.isEmpty())
            throw new NullPointerException("The universe does not exist");
        return universe.get();
    }

    //return Optional.ofNullable(universeRepository.getUniverseByCode(code)).orElseThrow(new RuntimeException("The universe does not exist"););



}
