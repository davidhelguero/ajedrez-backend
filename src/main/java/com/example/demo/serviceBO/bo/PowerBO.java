package com.example.demo.serviceBO.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerBO {

    private Long id;
    private String name;
    private Boolean active;
}
