package org.example.DTOs;

import java.util.Comparator;

public class Employee implements Comparator<Employee> {
    int empID;
    String firstName;
    String lastName;
    int age;
    String department;
    String role;
    Float hourlyRate;

    public Employee(int empID){
        this.empID=empID;
        this.firstName="";
        this.lastName="";
        this.age=0;
        this.department="";
        this.role="";
        this.hourlyRate= (float) 0;
    }

    public Employee(int empID, String firstName, String lastName, int age, String department, String role, Float hourlyRate) {
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.department = department;
        this.role = role;
        this.hourlyRate = hourlyRate;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}