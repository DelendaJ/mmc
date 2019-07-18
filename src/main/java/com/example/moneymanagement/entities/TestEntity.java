package com.example.moneymanagement.entities;

import javax.persistence.Entity;

@Entity
public class TestEntity {

    private String testFild;

    public String getTestFild() {
        return testFild;
    }

    public void setTestFild(String testFild) {
        this.testFild = testFild;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "testFild='" + testFild + '\'' +
                '}';
    }
}
