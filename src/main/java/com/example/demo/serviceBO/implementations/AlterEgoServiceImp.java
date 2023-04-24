package com.example.demo.serviceBO.implementations;

import com.example.demo.data.repository.AlterEgoRepository;
import com.example.demo.serviceBO.bo.AlterEgoBO;
import com.example.demo.serviceBO.interfaces.AlterEgoService;
import com.example.demo.serviceBO.mapper.AlterEgoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlterEgoServiceImp implements AlterEgoService {

    private final AlterEgoRepository alterEgoRepository;
    private final AlterEgoMapper alterEgoMapper;

    @Autowired
    public AlterEgoServiceImp(AlterEgoRepository alterEgoRepository, AlterEgoMapper alterEgoMapper) {
        this.alterEgoRepository = alterEgoRepository;
        this.alterEgoMapper = alterEgoMapper;
    }

    @Override
    public AlterEgoBO addAlterEgo(AlterEgoBO alterEgo) {
        return alterEgoMapper.alterEgoDEToBO(alterEgoRepository.save(alterEgoMapper.alterEgoBOToDE(alterEgo)));
    }

}
