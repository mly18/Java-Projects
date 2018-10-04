// Employee
public class Employee {
  
  // Name of the Employee
  private String name;
  
  // Salary of the Employee
  private double salary;
  
  // Number of the Employee
  private final int number;
  
  // Last Employee Number as a class field
  private static int lastEmployeeNumber = 0;
  
  // Create a constructor that requires atleast a name
  public Employee(String name) {
    this.name = name;
    this.number = lastEmployeeNumber + 1;
    Employee.lastEmployeeNumber = this.number;  // Employee.lastEmployeeNumber and not this. since it is a class field
  }
  
  // Get the salary of the Employee
  public double getSalary() {
    return this.salary;
  }
  
  // Change the salary of the Employee
  public void setSalary(Double salary) {
    this.salary = salary;
  }
  
  // Get the name of the Employee
  public String getName() {
    return this.name;
  }
  
  // Change the name of the Employee
  public void setName(String name) {
    this.name = name;
  }
  
  // Get the Employee Number
  public int getEmployeeNumber() {
    return this.number;
  }
}
  