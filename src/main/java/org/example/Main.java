package org.example;

import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;

public class Main {
    static void main() {

        Department department = new Department(1, "Books");
        IO.println(department);

        Seller seller = new Seller(21, "Hudson", "hudson@gmail.com", new Date(), 3000000.0, department);
        IO.println(seller);

    }
}
