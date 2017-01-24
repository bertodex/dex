package dex.main;

import java.util.List;

import org.apache.log4j.Logger;

import dex.bean.BuyedItem;
import dex.bean.Order;
import dex.util.TaxApplicationUtils;

public class TaxCalculator {
	
	private final static Logger LOGGER = Logger.getLogger(TaxCalculator.class);

    public static double elaborateOrder(Order order){
    	
    	List<BuyedItem> items = order.getList();
    	LOGGER.info("OUTPUT " + order.getName() + ":");
    	
    	for (BuyedItem item : items){
    		
    		double tax = 0d;
    		if ("1".equalsIgnoreCase(item.getType()))
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
