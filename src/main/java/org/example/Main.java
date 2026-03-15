package org.example;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.SellerDao;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;


import java.util.Date;
import java.util.List;

public class Main {
    static void main() {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        IO.println("=== Test 1: SELLER findById ===");
        Seller seller = sellerDao.findById(3);
        IO.println(seller);

        IO.println("=== Test 2: SELLER findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);
        for (Seller s : sellers) {
            IO.println(s);
        }

        IO.println("=== Test 3: seller Insert ===");
        Seller newSeller = new  Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        IO.println("Inserted! New id = " +newSeller.getId());

    }
}
