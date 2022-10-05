package Generics.curingasDelimitados.otherExample.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
  public static void main(String[] args) {

    List<Integer> numbersInts = Arrays.asList(1, 2, 3, 4);
    List<Double> numbersDoubles = Arrays.asList(3.14, 6.28);
    List<Object> list = new ArrayList<Object>();

    copy(numbersInts, list);
    printList(list);
    copy(numbersDoubles, list);
    printList(list);
  }

  public static void copy(List<? extends Number> source, List<? super Number> destiny) {
    for (Number number : source) {
      destiny.add(number);
    }
  }

  public static void printList(List<?> list) {
    for (Object obj : list) {
      System.out.println(obj);
    }

    System.out.println();
  }
}
