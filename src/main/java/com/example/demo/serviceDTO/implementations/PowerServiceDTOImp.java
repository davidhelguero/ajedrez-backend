package com.example.demo.serviceDTO.implementations;

import com.example.demo.api.dto.PowerResponseDTO;
import com.example.demo.serviceBO.bo.PowerBO;
import com.example.demo.serviceBO.interfaces.PowerServiceBO;
import com.example.demo.serviceDTO.interfaces.PowerServiceDTO;
import com.example.demo.serviceDTO.mapper.PowerMapperDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PowerServiceDTOImp implements PowerServiceDTO {

    private final PowerServiceBO powerServiceBO;
    private final PowerMapperDTO powerMapperDTO;

    public PowerServiceDTOImp(PowerServiceBO powerServiceBO, PowerMapperDTO powerMapperDTO) {
        this.powerServiceBO = powerServiceBO;
        this.powerMapperDTO = powerMapperDTO;
    }

    @Override
    public PowerResponseDTO addPower(PowerResponseDTO power) {
        PowerBO powerBO = powerMapperDTO.powerDTOToBO(power);
        return powerMapperDTO.powerBOToDTO(powerServiceBO.addPower(powerBO));
    }

    @Override
    public List<PowerResponseDTO> getPowers() {
       List<PowerBO> powers = powerServiceBO.getPowers();

       return powers.stream().parallel()
               .map(powerMapperDTO::powerBOToDTO)
               .collect(Collectors.toList());
    }

    @Override
    public PowerResponseDTO updatePower(String name, PowerResponseDTO power) {
        PowerBO powerBO = powerMapperDTO.powerDTOToBO(power);
        return powerMapperDTO.powerBOToDTO(powerServiceBO.updatePower(name, powerBO));
    }

    @Override
    public void deletePower(String name) {
        powerServiceBO.deletePower(name);
    }
}
