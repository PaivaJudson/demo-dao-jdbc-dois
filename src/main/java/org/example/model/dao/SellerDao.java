package org.example.model.dao;

import org.example.model.entities.Seller;

import java.util.List;

public interface SellerDao {
    void insert(Seller seller);
    void update(SellerDao seller);
    void delete(Integer id);
    SellerDao findById(Integer id);
    List<SellerDao> findAll();
}
