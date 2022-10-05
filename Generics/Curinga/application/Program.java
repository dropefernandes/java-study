package Generics.Curinga.application;

import java.util.Arrays;
import java.util.List;

public class Program {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(5, 2, 10);
    printList(numbers);
  }

  private static void printList(List<?> numbers) {
    for (Object obj : numbers) {
      System.out.println(obj);
    }
  }
}
