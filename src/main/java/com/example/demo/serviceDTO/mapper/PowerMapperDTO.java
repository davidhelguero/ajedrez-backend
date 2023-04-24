package com.example.demo.serviceDTO.mapper;

import com.example.demo.api.dto.PowerResponseDTO;
import com.example.demo.serviceBO.bo.PowerBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PowerMapperDTO {

    @Mapping(target = "id", ignore = true)
    PowerBO powerDTOToBO (PowerResponseDTO power);

    PowerResponseDTO powerBOToDTO (PowerBO powerBO);
}
