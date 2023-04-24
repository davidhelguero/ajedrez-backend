package com.example.demo.data.repository;

import com.example.demo.data.entity.HeroDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<HeroDE, Long> {

    @Query("SELECT a FROM HeroDE a WHERE a.name=:name")
    List<HeroDE> findHeroByName (String name);

    List<HeroDE> findByUniverse_Name (String name);

    @Query("SELECT c FROM HeroDE c WHERE (:universeName is null or c.universe.name = :universeName) and (:genderDescription is null or c.gender.description = :genderDescription)")
    List<HeroDE> findByUniverseAndGender(@Param("universeName") String universe, @Param("genderDescription") String genderDescription);

}
