package com.example.demo.data.repository;

import com.example.demo.data.entity.PowerDE;
import com.example.demo.data.entity.WeaknessDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaknessRepository extends JpaRepository<WeaknessDE, Long> {

    WeaknessDE findByName (String name);
}
