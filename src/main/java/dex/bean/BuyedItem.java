package dex.bean;

public class BuyedItem {
	
	private String type;
	private boolean imported;
	private String name;
	private double price;
	private double taxOnItem;
	private int quantity;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTaxOnItem() {
		return taxOnItem;
	}
	public void setTaxOnItem(double taxOnItem) {
		this.taxOnItem = taxOnItem;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
