package com.example.demo.serviceBO.mapper;

import com.example.demo.data.entity.WeaknessDE;
import com.example.demo.serviceBO.bo.WeaknessBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WeaknessMapper {

    WeaknessBO weaknessDEToBO(WeaknessDE weaknessDE);

    @Mapping(target = "heroes", ignore = true)
    WeaknessDE weaknessBOToDE(WeaknessDE weaknessBO);
}
