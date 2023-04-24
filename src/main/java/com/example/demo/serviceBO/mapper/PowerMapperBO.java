package com.example.demo.serviceBO.mapper;

import com.example.demo.data.entity.PowerDE;
import com.example.demo.serviceBO.bo.PowerBO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PowerMapperBO {

    PowerBO powerDEToBO(PowerDE powerDE);

    PowerDE powerBOToDE(PowerBO powerBO);
}
