package com.example.demo.serviceDTO.interfaces;

import com.example.demo.api.dto.PowerResponseDTO;

import java.util.List;

public interface PowerServiceDTO {

    PowerResponseDTO addPower(PowerResponseDTO power);

    List<PowerResponseDTO> getPowers();

    PowerResponseDTO updatePower(String name, PowerResponseDTO power);

    void deletePower(String name);

}
