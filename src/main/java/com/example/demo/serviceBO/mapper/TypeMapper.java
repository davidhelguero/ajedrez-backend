package com.example.demo.serviceBO.mapper;

import com.example.demo.data.entity.TypeDE;
import com.example.demo.serviceBO.bo.TypeBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    TypeBO typeDEToBO(TypeDE typeDE);

    TypeDE typeBOToDE(TypeBO typeBO);
}
