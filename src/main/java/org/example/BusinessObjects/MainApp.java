package org.example.BusinessObjects;

import org.example.DAOs.EmployeeDaoInterface;
import org.example.DAOs.MySqlEmployeeDao;
import org.example.DTOs.Employee;
import org.example.Exceptions.DaoException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Get all entities");
            System.out.println("2. Get entity by id");
            System.out.println("3. Delete entity by id");
            System.out.println("4. Insert an entity");
            System.out.println("5. update an entity");
            System.out.println("0. Exit");
            choice = key.nextInt();
            switch (choice) {
                case 1: {
                    EmployeeDaoInterface IEmployeeDao = new MySqlEmployeeDao();

                    //Feature 1: Display and return all employees
                    try {
                        System.out.println("\nCall getAllEmployees()");
                        List<Employee> employeesList = IEmployeeDao.getAllEmployees();

                        if (employeesList.isEmpty())
                            System.out.println("There are no employees");
                        else {
                            for (Employee e : employeesList)
                                System.out.println("Employee: " + e.toString());
                        }
                    } catch (DaoException ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    EmployeeDaoInterface IEmployeeDao = new MySqlEmployeeDao();
                    try {
                        Scanner kbrd = new Scanner(System.in);
                        System.out.println("\nCall: findEmployeeByID()");
                        System.out.println("Please enter ID");
                        int employeeID = kbrd.nextInt();
                        Employee employee = IEmployeeDao.findEmployeeById(employeeID);

                        if (employee != null) // null returned if userid and password not valid
                            System.out.println("Employee found: " + employee);
                        else
                            System.out.println("Employee not found");
                    }
                    catch(DaoException e )
                    {
                        e.printStackTrace();
                    }


                    break;
                }
                case 3: {
                    EmployeeDaoInterface IIIEmployeeDao = new MySqlEmployeeDao();
                    int id;
                    System.out.println("Enter the id of the employee you wish to delete: ");
                    id=key.nextInt();
                    try{
                        System.out.println("\n Calling DeleteEmployee()\n");
                        int deletedId= IIIEmployeeDao.DeleteEmployee(id);
                        System.out.println("Employee with id "+deletedId+" deleted successfully");
                        IIIEmployeeDao.getAllEmployees();
                    }catch (DaoException ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
                case 4: {
                    EmployeeDaoInterface IVEmployeeDao = new MySqlEmployeeDao();
                    String firstName;
                    String lastName;
                    int age;
                    String department;
                    String role;
                    float hourlyRate;
                    System.out.print("First name: ");
                    firstName = key.next();
                    System.out.print("Last name: ");
                    lastName = key.next();
                    System.out.print("Age: ");
                    age = key.nextInt();
                    /*This line fixes issue with nextInt() and nextLine() that was skipping over a line of input,
                     so inputs are read properly now.
                     */
                    key.nextLine();
                    System.out.print("Department: ");
                    department = key.nextLine();
                    System.out.print("Role: ");
                    role = key.nextLine();
                    System.out.print("Hourly rate: ");
                    hourlyRate = key.nextFloat();
                    Employee e = new Employee(0, firstName, lastName, age, department, role, hourlyRate);

                    try {

                        System.out.println("\n Calling InsertEmployee()\n");
                        Employee employee = IVEmployeeDao.InsertEmployee(e);
                        System.out.println("Employee inserted successfully");
                        System.out.println("Employee: " + employee);
                    } catch (DaoException ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
                case 5: {
                    EmployeeDaoInterface IUEmployeeDao = new MySqlEmployeeDao();
                    int empID;
                    System.out.println("Enter the ID of the employee you wish to update: ");
                    empID = key.nextInt();

                    key.nextLine();

                    System.out.println("Select fields to update (comma-separated, e.g., first_name,last_name,age): ");
                    String fieldsInput = key.nextLine();
                    String[] fields = fieldsInput.split(",");
                    List<String> fieldsToUpdate = Arrays.asList(fields);

                    Employee updatedEmployee = new Employee(0, null, null, 0, null, null, 0.0f);

                    updatedEmployee.setEmpID(empID);
                    for (String field : fieldsToUpdate) {
                        switch (field) {
                            case "first_name":
                                System.out.print("Enter new first name: ");
                                updatedEmployee.setFirstName(key.nextLine());
                                break;
                            case "last_name":
                                System.out.print("Enter new last name: ");
                                updatedEmployee.setLastName(key.nextLine());
                                break;
                            case "age":
                                System.out.print("Enter new age: ");
                                updatedEmployee.setAge(key.nextInt());
                                key.nextLine();
                                break;
                            case "department":
                                System.out.print("Enter new department: ");
                                updatedEmployee.setDepartment(key.nextLine());
                                break;
                            case "role":
                                System.out.print("Enter new role: ");
                                updatedEmployee.setRole(key.nextLine());
                                break;
                            case "hourly_rate":
                                System.out.print("Enter new hourly rate: ");
                                updatedEmployee.setHourlyRate(key.nextFloat());
                                key.nextLine();
                                break;
                        }
                    }

                    try {
                        System.out.println("\nCalling updateEmployee()\n");
                        Employee employee = IUEmployeeDao.updateEmployee(updatedEmployee, fieldsToUpdate);
                        System.out.println("Employee updated successfully");
                        System.out.println("Updated Employee: " + employee);
                    } catch (DaoException ex) {
                        ex.printStackTrace();
                    }
                    break;
                }


            }
        } while (choice != 0);

    }
}
