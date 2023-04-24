package com.example.demo.serviceBO.implementations;

import com.example.demo.data.entity.GenderDE;
import com.example.demo.data.repository.GenderRepository;
import com.example.demo.serviceBO.bo.GenderBO;
import com.example.demo.serviceBO.mapper.GenderMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
class GenderServiceImpTest {
    @Mock
    private GenderRepository genderRepository;
    @Mock
    private GenderMapper genderMapper;

    @InjectMocks
    private GenderServiceImp genderService;

    private GenderDE genderDE;
    private GenderBO genderBO;

   @BeforeEach
    void setUp() {

        genderDE = new GenderDE();
        genderDE.setId(1L);
        genderDE.setCode("G001");
        genderDE.setDescription("Hombre");

        genderBO = new GenderBO();
        //genderBO = genderMapper.genderDEToBO(genderDE);
        genderBO.setId(1L);
        genderBO.setCode("G001");
        genderBO.setDescription("Hombre");

    }

    @Test
    void getGenderByCode() {
        when(genderMapper.genderDEToBO(any(GenderDE.class))).thenReturn(genderBO);
        when(genderRepository.getGenderByCode("G001")).thenReturn(genderDE);
        assertNotNull(genderService.getGenderByCode("G001"));
    }

    @Test
    void getGenderByCodeNull() {
        when(genderMapper.genderDEToBO(any(GenderDE.class))).thenReturn(genderBO);
        when(genderRepository.getGenderByCode("G001")).thenReturn(genderDE);
        assertNull(genderService.getGenderByCode(null));
    }

    @Test
    void getGenderByCodeNotExist() throws NullPointerException{

        when(genderMapper.genderDEToBO(any(GenderDE.class))).thenReturn(genderBO);
        when(genderRepository.getGenderByCode("G001")).thenReturn(genderDE);

        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            genderService.getGenderByCode("G002");
        });

        Assertions.assertEquals("The gender does not exist", thrown.getMessage());
    }
}