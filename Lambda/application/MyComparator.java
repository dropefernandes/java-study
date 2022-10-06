package Lambda.application;

import java.util.Comparator;

import Lambda.entities.Product;

public class MyComparator implements Comparator<Product> {

  @Override
  public int compare(Product prev, Product next) {
    return prev.getName().toUpperCase().compareTo(next.getName().toUpperCase());
  }
}
