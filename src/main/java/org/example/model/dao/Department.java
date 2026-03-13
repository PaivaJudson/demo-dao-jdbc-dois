package org.example.model.entities.dao;

import java.util.List;

public interface Department {
    void insert(org.example.model.entities.Department department);
    void update(org.example.model.entities.Department department);
    void delete(Integer id);
    org.example.model.entities.Department findById(Integer id);
    List<org.example.model.entities.Department> findAll();
}

