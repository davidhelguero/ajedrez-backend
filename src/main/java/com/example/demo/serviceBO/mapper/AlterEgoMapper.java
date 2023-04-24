package com.example.demo.serviceBO.mapper;

import com.example.demo.data.entity.AlterEgoDE;
import com.example.demo.serviceBO.bo.AlterEgoBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlterEgoMapper {

    AlterEgoBO alterEgoDEToBO(AlterEgoDE alterEgoDE);

    @Mapping(target = "hero", ignore = true)
    AlterEgoDE alterEgoBOToDE(AlterEgoBO alterEgoBO);
}
