package Generics.Delimitados.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Generics.Delimitados.entities.Product;
import Generics.Delimitados.services.CalculationService;

public class Program {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    List<Product> products = new ArrayList<>();
    String path = "/Users/pedrofernandes/Development/drope/java/Generics/Delimitados/products.txt";

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

      String line = bufferedReader.readLine();

      while (line != null) {
        String[] fields = line.split(",");
        products.add(new Product(fields[0], Double.parseDouble(fields[1])));
        System.out.println(fields[0] + ", " + fields[1]);
        line = bufferedReader.readLine();
      }

      Product product = CalculationService.max(products);
      System.out.println("Most expensive: ");
      System.out.println(product);

    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
