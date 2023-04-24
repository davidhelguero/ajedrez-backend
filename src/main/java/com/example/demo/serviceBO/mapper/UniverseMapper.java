package com.example.demo.serviceBO.mapper;

import com.example.demo.api.dto.UniverseDTO;
import com.example.demo.data.entity.UniverseDE;
import com.example.demo.serviceBO.bo.UniverseBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UniverseMapper {

    UniverseDTO universeBOToDTO(UniverseBO universeBO);

    @Mapping(target = "id", ignore = true)
    UniverseBO universeDTOToBO(UniverseDTO universeDTO);

    UniverseBO universeDEToBO(UniverseDE universeDE);

    UniverseDE universeBOToDE(UniverseBO universeBO);
}
