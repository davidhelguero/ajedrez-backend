package com.example.demo.serviceBO.implementations;

import com.example.demo.data.entity.TypeDE;
import com.example.demo.data.entity.UniverseDE;
import com.example.demo.data.repository.TypeRepository;
import com.example.demo.serviceBO.bo.TypeBO;
import com.example.demo.serviceBO.interfaces.TypeService;
import com.example.demo.serviceBO.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeServiceImp implements TypeService {

    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    @Autowired
    public TypeServiceImp(TypeRepository typeRepository, TypeMapper typeMapper) {
        this.typeRepository = typeRepository;
        this.typeMapper = typeMapper;
    }

    @Override
    public TypeBO getTypeByCode(String code) {
        if(code == null)
            return null;
        Optional<TypeDE> type = Optional.ofNullable(typeRepository.getTypeByCode(code));
        if(type.isEmpty())
            throw new NullPointerException("The type does not exist");
        return typeMapper.typeDEToBO(type.get());
    }
}
