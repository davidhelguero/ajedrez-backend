package com.example.demo.data.repository;

import com.example.demo.data.entity.EnemyDE;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EnemyRepository extends JpaRepository<EnemyDE, Long> {

    @Query("SELECT a FROM EnemyDE a WHERE a.name=:name")
    EnemyDE getEnemyByName(String name);
}
