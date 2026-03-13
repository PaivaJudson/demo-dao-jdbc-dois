package org.example.model.dao;

import java.util.List;
import org.example.model.entities.Department;

public interface DepartmentDao {
    void insert(Department department);
    void update(Department department);
    void delete(Integer id);
    Department findById(Integer id);
    List<Department> findAll();
}

