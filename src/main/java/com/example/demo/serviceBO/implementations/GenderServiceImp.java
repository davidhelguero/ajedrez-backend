package com.example.demo.serviceBO.implementations;

import com.example.demo.data.entity.GenderDE;
import com.example.demo.data.repository.GenderRepository;
import com.example.demo.serviceBO.bo.GenderBO;
import com.example.demo.serviceBO.interfaces.GenderService;
import com.example.demo.serviceBO.mapper.GenderMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenderServiceImp implements GenderService {

    private final GenderRepository genderRepository;
    private final GenderMapper genderMapper;

    public GenderServiceImp(GenderRepository genderRepository, GenderMapper genderMapper) {
        this.genderRepository = genderRepository;
        this.genderMapper = genderMapper;
    }

    @Override
    public GenderBO getGenderByCode(String code) {
        if(code == null)
            return null;
        Optional<GenderDE> gender = Optional.ofNullable(genderRepository.getGenderByCode(code));
        if(gender.isEmpty())
            throw new NullPointerException("The gender does not exist");
        return genderMapper.genderDEToBO(gender.get());
    }

}