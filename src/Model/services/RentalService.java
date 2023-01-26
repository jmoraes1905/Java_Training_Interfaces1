package Model.services;

import java.time.Duration;

import Model.entities.CarRental;
import Model.entities.Invoice;

public class RentalService {
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	//This class now does not depend on specific tax services
	//allowing to change the specific service at the constructor in the main Program
	//This works just like an upcasting
	private TaxService taxService; 

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public void processInvoice(CarRental carRental) {
		
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = minutes/60.0;
		
		double basicPayment;
		
		if(hours<=12.0) {
			basicPayment = pricePerHour*Math.ceil(hours); //hours are rounded up
		}
		else {
			basicPayment = pricePerDay*Math.ceil(hours/24.0);
		}
		
		double tax = taxService.tax(basicPayment);
		
	    carRental.setInvoice(new Invoice(basicPayment,tax));
	
	
	}
	
	

}
