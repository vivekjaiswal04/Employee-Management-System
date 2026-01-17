package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    private String empMiddleName;
    private String empSurname;
    private String empAddress;
    private String empDepartment;
    private double empSalary;

    // --- Getters and Setters ---
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpMiddleName() {
        return empMiddleName;
    }
    public void setEmpMiddleName(String empMiddleName) {
        this.empMiddleName = empMiddleName;
    }

    public String getEmpSurname() {
        return empSurname;
    }
    public void setEmpSurname(String empSurname) {
        this.empSurname = empSurname;
    }

    public String getEmpAddress() {
        return empAddress;
    }
    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }
    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public double getEmpSalary() {
        return empSalary;
    }
    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

   
}
