package com.example.demo.data.repository;

import com.example.demo.data.entity.AlterEgoDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlterEgoRepository extends JpaRepository<AlterEgoDE, Long> {

    @Query("SELECT a FROM AlterEgoDE a WHERE a.name=:name")
    AlterEgoDE getAlterEgoByName(String name);
}
