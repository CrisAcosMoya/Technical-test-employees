package com.technical.employees.model;

public class Employee {

    private int id;

    private String employeeName;

    private int employeeSalary;

    private int employeeAge;

    private String profileImage;

    private int employeeAnnualSalary;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }
    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getEmployeeAnnualSalary() {
        return employeeAnnualSalary;
    }
    public void setEmployeeAnnualSalary(int employeeAnnualSalary) {
        this.employeeAnnualSalary = employeeAnnualSalary;
    }
}
