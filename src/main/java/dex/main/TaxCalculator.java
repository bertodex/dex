package dex.main;

import java.util.List;

import org.apache.log4j.Logger;

import dex.bean.BuyedItem;
import dex.bean.Order;
import dex.util.Constants;
import dex.util.TaxApplicationUtils;

public class TaxCalculator {
	
	private final static Logger LOGGER = Logger.getLogger(TaxCalculator.class);

	/**
	 * Elaborate tax amount for all BuyedItem in an Order.
	 * For each item, it checks if item is taxable or not and, in case of importation, it computes 
	 * the relative tax (basing on the original item price).
	 * Once computed, it stores all values inside Bean fields.
	 * 
	 * I used double instead of BigDecimal or Double for a couple of reason:
	 * - double (primitive) are quicker the the Object counterpart
	 * - I think BigDecimal precision isn't required when computing numbers with 2 decimal
	 * - it doesn't require value conversion
	 * 
	 * Considering that double are floating point numbers, I create a fix method in Utilites Class to correct round-off error
	 * when two double (decimal) are summed.
	 *  
	 * @param order
	 * @return the total tax for the current order (used for jUnit tests)
	 */
    public static double elaborateOrder(Order order){
    	
    	List<BuyedItem> items = order.getList();
    	LOGGER.info("OUTPUT " + order.getName() + ":");
    	
    	for (BuyedItem item : items){
    		
    		double tax = 0d;
    		if (Constants.TAXED_ITEM.equalsIgnoreCase(item.getType()))
    				tax = TaxApplicationUtils.getAppliedTax(item.getPrice());
    		if (item.isImported())
    			tax += TaxApplicationUtils.getImportedAdditionalTax(item.getPrice());
    		
    		tax = TaxApplicationUtils.roundTax(tax);
    		
    		item.setTaxOnItem(tax);
    		double itemTaxed = (TaxApplicationUtils.formatDecimalPart((item.getPrice() + item.getTaxOnItem())));
    		
    		order.setAppliedTax(TaxApplicationUtils.formatDecimalPart(item.getTaxOnItem() * item.getQuantity() + order.getAppliedTax()));
    		order.setTotal(TaxApplicationUtils.formatDecimalPart(order.getTotal() + (itemTaxed * item.getQuantity())));
    		
    		LOGGER.info(item.getQuantity() + " " + item.getName() + ": " + (item.getQuantity() * itemTaxed));
    	}
    	
    	LOGGER.info("Sales Taxes: " + order.getAppliedTax());
    	LOGGER.info("Total: " + order.getTotal());
    	return order.getAppliedTax();
    }
    
}
