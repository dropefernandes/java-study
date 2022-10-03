package Interface.model.services;

import Interface.model.entities.CarRental;
import Interface.model.entities.Invoice;

public class RentalService {

  private Double pricePerDay;
  private Double pricePerHour;

  private TaxService taxService;

  public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
    this.pricePerDay = pricePerDay;
    this.pricePerHour = pricePerHour;
    this.taxService = taxService;
  }

  public void processInvoice(CarRental carRental) {
    long start = carRental.getStart().getTime();
    long end = carRental.getFinish().getTime();
    double hours = (double) (end - start) / 1000 / 60 / 60;
    double basicPayment;

    if (hours <= 12.0) {
      basicPayment = pricePerHour * Math.ceil(hours);
    } else {
      basicPayment = pricePerDay * Math.ceil(hours / 24);
    }

    carRental.setInvoice(new Invoice(basicPayment, taxService.tax(basicPayment)));
  }
}
