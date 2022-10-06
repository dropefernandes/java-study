package Lambda.application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Lambda.entities.Product;

public class Program {
  public static void main(String[] args) {

    List<Product> products = new ArrayList<>();

    products.add(new Product("Tv", 900.00));
    products.add(new Product("Notebook", 1200.00));
    products.add(new Product("Tablet", 450.00));

    Comparator<Product> comparator = new Comparator<Product>() {
      @Override
      public int compare(Product p1, Product p2) {
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
      }
    };

    products.sort(comparator);

    for (Product product : products) {
      System.out.println(product);
    }

  }
}
