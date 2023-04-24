package com.example.demo.data.repository;

import com.example.demo.data.entity.HeroPowerDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroPowerRepository extends JpaRepository<HeroPowerDE, Long> {

}
