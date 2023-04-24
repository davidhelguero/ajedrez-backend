package com.example.demo.serviceBO.interfaces;

import com.example.demo.data.entity.UniverseDE;
import com.example.demo.serviceBO.bo.UniverseBO;

public interface UniverseService {
    UniverseBO getUniverseByCode(String code);

    UniverseDE getUniverseByName(String name);
}
