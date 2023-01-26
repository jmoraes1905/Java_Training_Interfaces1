package Model.services;

public interface TaxService {
	//Avoids dependence of one particular country tax system
	//Alloes greater flexibility to change tax dependency of other project's classes
	double tax(double amount);

}
