package com.example.demo.serviceBO.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroPowerBO {

    private Long id;
    private PowerBO power;
    private String event;
    private boolean active;

}
