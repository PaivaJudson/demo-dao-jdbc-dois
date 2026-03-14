package org.example.model.dao.impl;

import org.example.db.DbException;
import org.example.model.dao.SellerDao;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection connection;

    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Seller seller) {

    }

    @Override
    public void update(SellerDao seller) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String str = "SELECT seller.*, department.Name as DepName "
                    +"FROM seller INNER JOIN department "
                    +"ON department.Id = seller.DepartmentId "
                    +"WHERE seller.Id = ?";

        try {
            preparedStatement = connection.prepareStatement(str);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Department department = instantiateDepartment(resultSet);
                Seller  seller = instantiateSeller(resultSet,department);

                seller.setDepartment(department);

                return seller;
            }

            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {

        }

    }

    private Seller instantiateSeller(ResultSet resultSet, Department department) throws SQLException {

        Seller seller = new Seller();

        seller.setId(resultSet.getInt("Id"));
        seller.setName( resultSet.getString("Name"));
        seller.setEmail(resultSet.getString("Email"));
        seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
        seller.setBirthDate(resultSet.getDate("BirthDate"));

        return seller;
    }

    private Department instantiateDepartment(ResultSet resultSet) throws SQLException {

        Department department = new Department();
        department.setId(resultSet.getInt("DepartmentId"));
        department.setName(resultSet.getString("DepName"));

        return department;
    }

    @Override
    public List<SellerDao> findAll() {
        return List.of();
    }
}
