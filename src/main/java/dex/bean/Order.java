package dex.bean;

import java.util.List;

/**
 * Bean referring to a generic order - identified by a name.
 * It contains a list of BuyedItems and two fields, regarding total price and applied taxation. 
 * @author Dex
 *
 */
public class Order {
	
	private List<BuyedItem> list;
	private double total;
	private double appliedTax;
	private String name;
	
	public List<BuyedItem> getList() {
		return list;
	}
	public void setList(List<BuyedItem> list) {
		this.list = list;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getAppliedTax() {
		return appliedTax;
	}
	public void setAppliedTax(double appliedTax) {
		this.appliedTax = appliedTax;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
