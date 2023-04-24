package com.example.demo.api;

import com.example.demo.api.dto.PowerResponseDTO;
import com.example.demo.exceptions.ControllerAdvice;
import com.example.demo.serviceDTO.interfaces.PowerServiceDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
class PowerControllerTest {

    MockMvc mockMvc;
    @Mock
    private PowerServiceDTO powerServiceDTO;
    private PowerResponseDTO powerResponseDTO;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new PowerController(powerServiceDTO))
                .setControllerAdvice(new ControllerAdvice())
                .build();

        powerResponseDTO = new PowerResponseDTO(1L,"Volar",true);
        objectMapper = new ObjectMapper();
    }

    @Test
    void addPower() throws Exception {
        when(powerServiceDTO.addPower(any(PowerResponseDTO.class))).thenReturn(powerResponseDTO);

        ResultActions perform = mockMvc.perform(put("/powers").content(objectMapper.writeValueAsString(powerResponseDTO)));

        perform.andExpect(status().isOk()).andDo(print());
    }

    @Test
    void getPowers() {
    }

    @Test
    void updatePower() {
    }

    @Test
    void deletePower() {
    }
}