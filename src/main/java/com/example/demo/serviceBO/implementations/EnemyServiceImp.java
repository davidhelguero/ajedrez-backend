package com.example.demo.serviceBO.implementations;

import com.example.demo.data.repository.EnemyRepository;
import com.example.demo.serviceBO.bo.EnemyBO;
import com.example.demo.serviceBO.interfaces.EnemyService;
import com.example.demo.serviceBO.mapper.EnemyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnemyServiceImp implements EnemyService {

    private final EnemyRepository enemyRepository;
    private final EnemyMapper enemyMapper;

    @Autowired
    public EnemyServiceImp(EnemyRepository enemyRepository, EnemyMapper enemyMapper) {
        this.enemyRepository = enemyRepository;
        this.enemyMapper = enemyMapper;
    }

    @Override
    public EnemyBO addEnemy(EnemyBO enemy) {
        return enemyMapper.enemyDEToBO(enemyRepository.save(enemyMapper.enemyBOToDE(enemy)));
    }

}
