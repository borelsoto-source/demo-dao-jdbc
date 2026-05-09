package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entites.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: Department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n=== Test 2: Department findAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		/*
		System.out.println("\n=== Test 3: Department insert ===");
		Department newDepartment = new Department(null, "D3");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId());
				
		System.out.println("\n=== Test 4: Department Update ===");
		department = departmentDao.findById(7);
		department.setName("Food");
		departmentDao.update(department);
		System.out.println("Update completed!");
		*/
		
		System.out.println("\n=== Test 5: Department delete ===");
		System.out.print("Enter id depertment for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted! Id = " + id);
		
		sc.close();
		DB.closeConnection();
	}

}
