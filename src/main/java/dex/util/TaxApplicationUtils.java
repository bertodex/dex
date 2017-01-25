package dex.util;

public class TaxApplicationUtils {

	/**
	 * Compute the correct double rounded up to the nearest 0.05
	 * @param tax
	 * @return
	 */
	public static double roundTax(double tax){
		return Math.ceil(tax * 20) / 20.0;
	}
	
	/**
	 * Used to correct the round-off error present in these floating point numbers (like double). 
	 * (considering Tax and Price are all with a 2 digit decimal part)
	 * @param tax
	 * @return
	 */
	public static double formatDecimalPart(double tax){
		return Math.round(tax * 100) / 100.0;
	}
	
	/**
	 * 
	 * @param total
	 * @return
	 */
	public static double getAppliedTax(double total){
		return getAppliedTax(total, 10);
	}
	
	/**
	 * Compute the taxation amount of a specific payoff
	 * @param total
	 * @param taxPerc
	 * @return
	 */
	public static double getAppliedTax(double total, double taxPerc){
		return total * (taxPerc/100);
	}
	
	/**
	 * Compute the 5% tax for imported goods
	 * @param totalTaxed
	 * @return
	 */
	public static double getImportedAdditionalTax(double totalTaxed){
		return totalTaxed * 0.05;
	}
	
}