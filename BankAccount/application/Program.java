package BankAccount.application;

import java.util.Locale;
import java.util.Scanner;

import BankAccount.model.entities.Account;
import BankAccount.model.exception.BusinessException;

public class Program {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter account data");
    System.out.print("Number: ");
    int number = sc.nextInt();
    System.out.print("Holder: ");
    sc.nextLine();
    String holder = sc.nextLine();
    System.out.print("Initial Balance: ");
    double balance = sc.nextDouble();
    System.out.print("Withdraw Limit: ");
    double withDraw = sc.nextDouble();

    Account account = new Account(number, holder, balance, withDraw);
    System.out.print("Enter amount for withdraw: ");

    try {
      account.withDraw(sc.nextDouble());
      System.out.printf("Novo saldo: %.2f%n", account.getBalance());
    } catch (BusinessException e) {
      System.out.println(e.getMessage());
    }

    sc.close();
  }
}
