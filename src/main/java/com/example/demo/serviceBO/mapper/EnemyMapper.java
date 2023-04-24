package com.example.demo.serviceBO.mapper;

import com.example.demo.data.entity.EnemyDE;
import com.example.demo.serviceBO.bo.EnemyBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnemyMapper {

    EnemyBO enemyDEToBO(EnemyDE enemyDE);

    @Mapping(target = "hero", ignore = true)
    EnemyDE enemyBOToDE(EnemyBO enemyBO);
}
