package LambdaPractice.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import LambdaPractice.entities.Employee;

public class Program {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter full file path: ");
    String filePath = sc.nextLine();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

      List<Employee> employees = new ArrayList<>();
      String line = bufferedReader.readLine();

      while (line != null) {
        String[] fields = line.split(",");
        employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
        line = bufferedReader.readLine();
      }

      System.out.println("Enter salary: ");
      double salaryFilter = sc.nextDouble();

      List<String> emails = employees.stream()
          .filter(e -> e.getSalary() > salaryFilter)
          .map(e -> e.getEmail())
          .sorted()
          .collect(Collectors.toList());

      System.out.println("Email of people whose salary is more than " + String.format("%.2f", salaryFilter) + ":");
      emails.forEach(System.out::println);

      double sum = employees.stream()
          .filter(e -> e.getName().charAt(0) == 'M')
          .map(e -> e.getSalary())
          .reduce(0.0, (x, y) -> x + y);

      System.out.println("Sum of salary from people whose name starts with 'M': " + String.format("%.2f", sum));

    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }

    sc.close();
  }
}
