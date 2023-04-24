package com.example.demo.data.repository;

import com.example.demo.data.entity.TypeDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<TypeDE, Long> {

    @Query("SELECT a FROM TypeDE a WHERE a.code=:code")
    TypeDE getTypeByCode(String code);
}
