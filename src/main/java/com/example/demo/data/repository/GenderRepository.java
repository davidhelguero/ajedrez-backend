package com.example.demo.data.repository;

import com.example.demo.data.entity.GenderDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<GenderDE, Long> {

    @Query("SELECT a FROM GenderDE a WHERE a.code=:code")
    GenderDE getGenderByCode(String code);
}
