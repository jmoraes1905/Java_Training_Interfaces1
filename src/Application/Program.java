package Application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Model.entities.CarRental;
import Model.entities.Vehicle;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter with rent data:");
		System.out.println("Car model:");
		String carModel = sc.nextLine();
		System.out.println("Rent date (dd/MM/yyyy)");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.println("Return date (dd/MM/yyyy)");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);
		
		CarRental cr = new CarRental(start,finish,new Vehicle(carModel));
		
		sc.close();
	}

}
