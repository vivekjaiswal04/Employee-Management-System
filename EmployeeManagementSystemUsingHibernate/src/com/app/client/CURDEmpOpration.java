package com.app.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.model.Employee;

import hibernateUtil.HibernateUtil;

/**
 * CURDEmpOpration class performs basic CRUD operations (Create, Read, Update, Delete)
 * for Employee records using Hibernate ORM.
 * 
 * It uses a menu-driven console-based interface.
 */
public class CURDEmpOpration {

    // --- Scanner for user input ---
    static Scanner sc = new Scanner(System.in);

    // --- Employee object and list to store employees temporarily ---
    Employee emp = new Employee();
    List<Employee> list = new ArrayList<Employee>();

    // --- Hibernate session and factory setup ---
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();

    /**
     * Inserts multiple Employee records into the database.
     */
    public void insertValue() {

        // --- Employee 1 ---
        Employee e1 = new Employee();
        e1.setEmpName("Manav");
        e1.setEmpMiddleName("Ramesh");
        e1.setEmpSurname("Pethe");
        e1.setEmpAddress("Pune");
        e1.setEmpDepartment("IT");
        e1.setEmpSalary(85000.75);

        // --- Employee 2 ---
        Employee e2 = new Employee();
        e2.setEmpName("Sneha");
        e2.setEmpMiddleName("Sunil");
        e2.setEmpSurname("Sharma");
        e2.setEmpAddress("Mumbai");
        e2.setEmpDepartment("HR");
        e2.setEmpSalary(78000.25);

        // --- Employee 3 ---
        Employee e3 = new Employee();
        e3.setEmpName("Rahul");
        e3.setEmpMiddleName("Suresh");
        e3.setEmpSurname("Patil");
        e3.setEmpAddress("Nagpur");
        e3.setEmpDepartment("Finance");
        e3.setEmpSalary(92000.50);

        // --- Employee 4 ---
        Employee e4 = new Employee();
        e4.setEmpName("Kavya");
        e4.setEmpMiddleName("Mohan");
        e4.setEmpSurname("Deshmukh");
        e4.setEmpAddress("Nashik");
        e4.setEmpDepartment("Marketing");
        e4.setEmpSalary(88000.00);

        // --- Employee 5 ---
        Employee e5 = new Employee();
        e5.setEmpName("Amit");
        e5.setEmpMiddleName("Prakash");
        e5.setEmpSurname("Kulkarni");
        e5.setEmpAddress("Aurangabad");
        e5.setEmpDepartment("Operations");
        e5.setEmpSalary(83000.90);

        // Add all employees to list
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);

        // Persist all employees to DB using Hibernate
        for (Employee e : list) {
            session.persist(e);
            session.beginTransaction().commit();
        }

        session.close();
        sf.close();
        System.out.println("✅ Data Inserted Successfully!");
    }

    /**
     * Deletes an Employee record from the database by ID.
     */
    public void deleteValue() {
        System.out.println("Enter Employee ID to Delete Details:");
        int del = sc.nextInt();

        emp.setEmpId(del);
        session.delete(emp);
        session.beginTransaction().commit();
        session.close();
        sf.close();

        System.out.println("✅ Employee ID " + del + " Deleted Successfully!");
    }

    /**
     * Updates an existing Employee record in the database.
     */
    public void updateValue() {
        System.out.println("Enter Employee ID to Update Employee Details:");
        int id = sc.nextInt();

        System.out.println("Enter Employee Name to Update:");
        String name = sc.next();

        System.out.println("Enter Employee Middle Name:");
        String mName = sc.next();

        System.out.println("Enter Employee Surname:");
        String surname = sc.next();

        System.out.println("Enter Employee Address:");
        String address = sc.next();

        System.out.println("Enter Employee Department:");
        String dep = sc.next();

        System.out.println("Enter Employee Salary:");
        double sal = sc.nextDouble();

        // Set updated values in employee object
        emp.setEmpId(id);
        emp.setEmpName(name);
        emp.setEmpMiddleName(mName);
        emp.setEmpSurname(surname);
        emp.setEmpAddress(address);
        emp.setEmpDepartment(dep);
        emp.setEmpSalary(sal);

        // Update record using Hibernate
        session.update(emp);
        session.beginTransaction().commit();
        session.close();
        sf.close();

        System.out.println("✅ Employee ID " + id + " Updated Successfully!");
    }

    /**
     * Retrieves and displays Employee records by ID range (1 to 10).
     */
    public void retriveValue() {
        for (int i = 1; i <= 10; i++) {
            Employee e = session.get(Employee.class, i);

            if (e != null) {
                System.out.println("==============================");
                System.out.println("Employee ID: " + e.getEmpId());
                System.out.println("Employee Name: " + e.getEmpName());
                System.out.println("Middle Name: " + e.getEmpMiddleName());
                System.out.println("Surname: " + e.getEmpSurname());
                System.out.println("Address: " + e.getEmpAddress());
                System.out.println("Department: " + e.getEmpDepartment());
                System.out.println("Salary: ₹" + e.getEmpSalary());
            } else {
                System.out.println("==============================");
                System.out.println("Data not found for Employee ID: " + i);
            }
        }
    }

    /**
     * Displays menu-driven console options for CRUD operations.
     */
    public void menu() {
        System.out.println("\n==============================");
        System.out.println("   Employee Management System ");
        System.out.println("==============================");
        System.out.println("Enter 1 for Insert The Data!");
        System.out.println("Enter 2 for Delete The Data!");
        System.out.println("Enter 3 for Update The Data!");
        System.out.println("Enter 4 for Retrieve The Data!");
        System.out.println("Enter 5 for Exit!");
        System.out.print("Enter Your Choice: ");

        int result = sc.nextInt();

        switch (result) {
            case 1:
                insertValue();
                break;

            case 2:
                deleteValue();
                break;

            case 3:
                updateValue();
                break;

            case 4:
                retriveValue();
                break;

            case 5:
                System.out.println("🏁 Exiting... Thank You!");
                System.exit(0);
                break;

            default:
                System.out.println("❌ Invalid choice! Please enter 1–5.");
        }

        // Recursive call to show menu again
        menu();
    }

    /**
     * Main method — program entry point.
     */
    public static void main(String[] args) {
        CURDEmpOpration empOpration = new CURDEmpOpration();
        empOpration.menu();
    }
}
