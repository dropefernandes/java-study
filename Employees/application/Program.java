package Employees.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Employees.entities.Employee;

public class Program {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    List<Employee> employees = new ArrayList<>();

    System.out.print("How many employees will be registered? ");
    int amountEmployees = sc.nextInt();

    for (int i = 1; i <= amountEmployees; i++) {
      System.out.println();
      System.out.println("Employee #" + i + ": ");

      System.out.println("Id: ");
      int id = sc.nextInt();

      while (hasId(employees, id)) {
        System.out.println("Id Already taken. Try again: ");
        id = sc.nextInt();
      }

      System.out.println("Name: ");
      sc.nextLine();
      String name = sc.nextLine();
      System.out.println("Salary: ");
      double salary = sc.nextDouble();
      employees.add(new Employee(id, name, salary));
    }

    System.out.println();
    System.out.print("Enter the employee id that will have salary increase: ");
    int id = sc.nextInt();
    Employee emp = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    if (emp == null) {
      System.out.println("This id does not exist!");
    } else {
      System.out.print("Enter the percentage: ");
      double percentage = sc.nextDouble();
      emp.increaseSalary(percentage);
    }

    // PART 3 - LISTING EMPLOYEES:

    System.out.println();
    System.out.println("List of employees:");
    for (Employee employee : employees) {
      System.out.println(employee);
    }

    sc.close();
  }

  public static boolean hasId(List<Employee> list, int id) {
    Employee employee = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    return employee != null;
  }
}