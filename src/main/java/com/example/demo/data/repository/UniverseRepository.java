package com.example.demo.data.repository;

import com.example.demo.data.entity.UniverseDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UniverseRepository extends JpaRepository<UniverseDE, Long> {

    @Query("SELECT a FROM UniverseDE a WHERE a.code=:code")
    UniverseDE getUniverseByCode(String code);

    UniverseDE findFirstByName(String name);
}
