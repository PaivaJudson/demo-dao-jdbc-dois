package org.example;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.SellerDao;


import java.util.Date;

public class Main {
    static void main() {

        SellerDao sellerDao = DaoFactory.createSellerDao();

    }
}
