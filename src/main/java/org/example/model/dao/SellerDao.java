package org.example.model.dao;

import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.List;

public interface SellerDao {
    void insert(Seller seller);
    void update(SellerDao seller);
    void delete(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);
}
