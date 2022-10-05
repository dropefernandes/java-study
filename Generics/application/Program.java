package Generics.application;

import java.util.Locale;
import java.util.Scanner;

import Generics.services.PrintService;

public class Program {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    PrintService<Integer> printService = new PrintService<>();

    System.out.println("How many values? ");
    int quantity = sc.nextInt();

    for (int i = 0; i < quantity; i++) {
      Integer value = sc.nextInt();
      printService.addValue(value);
    }

    printService.print();
    System.out.println("First: " + printService.first());

    sc.close();
  }
}
