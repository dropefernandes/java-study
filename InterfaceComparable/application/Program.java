package InterfaceComparable.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import InterfaceComparable.entities.Employee;

public class Program {
  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();
    String path = "/Users/pedrofernandes/Development/drope/java/InterfaceComparable/in.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String employee = br.readLine();
      while (employee != null) {
        String[] fields = employee.split(",");
        employees.add(new Employee(fields[0], Double.parseDouble(fields[1])));
        employee = br.readLine();
      }
      Collections.sort(employees);
      for (Employee emp : employees) {
        System.out.println(emp.getName() + ", " + emp.getSalary());
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
