package com.example.demo.serviceBO.interfaces;

import com.example.demo.api.dto.PowerDTO;
import com.example.demo.api.dto.PowerResponseDTO;
import com.example.demo.data.entity.PowerDE;
import com.example.demo.serviceBO.bo.PowerBO;

import java.util.List;

public interface PowerServiceBO {

    PowerBO addPower(PowerBO powerBO);

    List<PowerBO> getPowers();

    PowerBO getPowerByName(String name);

    PowerBO updatePower(String name, PowerBO powerBO);

    void deletePower(String name);
}
