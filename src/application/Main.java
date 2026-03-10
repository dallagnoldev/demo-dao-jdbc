package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test 2: seller findByDepartment ===");
        List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 3: seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj: list) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 4: seller insert ===");

        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDate.parse("01/01/2000", dtf), 4000.0, new Department(2, null));
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Id: " + newSeller.getId());

        System.out.println("\n=== Test 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Update Completed");

    }
}
