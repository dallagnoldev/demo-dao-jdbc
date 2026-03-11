package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("Insert: ");

        Department dep = new Department(null, "Movies");
        departmentDao.insert(dep);
        System.out.println("Inserted! New Id: " + dep.getId());

        System.out.println("\nUpdate: ");
        dep = departmentDao.findById(4);
        dep.setName("Sports");
        departmentDao.update(dep);
        System.out.println("Department updated");

        System.out.println("\nFindById: ");
        dep = departmentDao.findById(7);
        System.out.println(dep);

        System.out.println("\nDelete: ");
        departmentDao.deleteById(3);
        System.out.println("Department deleted");

        System.out.println("\nFindAll: ");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

    }
}
