package com.example.moneymanagement.services;

import com.example.moneymanagement.entities.TestEntity;
import com.example.moneymanagement.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<TestEntity> findAll() {

        return testRepository.findAll();
    }
}
