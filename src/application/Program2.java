package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n=== TEST 1: department findById ===");
        System.out.println(departmentDao.findById(4));

        System.out.println("=== TEST 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: department insert ===");
        Department newDepartment = new Department (null, "Home");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 4: department update ===");
        Department dep = departmentDao.findById(3);
        dep.setName("Beer");
        departmentDao.update(dep);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: department delete ===");
        System.out.print("Enter id for delete test: ");
        departmentDao.deleteById(sc.nextInt());
        System.out.println("Delete completed");

    }
    
}
