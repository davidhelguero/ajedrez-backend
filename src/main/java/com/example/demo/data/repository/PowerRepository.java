package com.example.demo.data.repository;

import com.example.demo.data.entity.PowerDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerRepository extends JpaRepository<PowerDE, Long> {

    @Query("SELECT a FROM PowerDE a WHERE a.name=:name")
    PowerDE findPowerByName (String name);

    List<PowerDE> findByActiveTrue();

    //List<PowerDE> findByNameAndActiveTrue();
}
