package com.example.moneymanagement.controllers;

import com.example.moneymanagement.entities.TestEntity;
import com.example.moneymanagement.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/api/v1/test")
public class TestController {

    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public @ResponseBody List<TestEntity> getTestEntities() {

        return testService.findAll();
    }
}
