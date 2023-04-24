package com.example.demo.serviceBO.mapper;

import com.example.demo.data.entity.GenderDE;
import com.example.demo.serviceBO.bo.GenderBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderMapper {

    GenderBO genderDEToBO(GenderDE genderDE);

    GenderDE genderBOToDE(GenderBO genderBO);
}
