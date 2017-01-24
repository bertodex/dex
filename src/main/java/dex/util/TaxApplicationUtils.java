package dex.util;

public class TaxApplicationUtils {

	public static double roundTax(double tax){
		return Math.ceil(tax * 20) / 20.0;
	}
	
	public static double formatDecimalPart(double tax){
		return Math.round(tax * 100) / 100.0;
	}
	
	public static double getAppliedTax(double total){
		return getAppliedTax(total, 10);
	}
	
	public static double getAppliedTax(double total, double taxPerc){
		return total * (taxPerc/100);
	}
	
	public static double getImportedAdditionalTax(double totalTaxed){
		return totalTaxed * 0.05;
	}
	
}