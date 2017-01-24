package dex.taxTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dex.bean.BeanFactory;
import dex.bean.BuyedItem;
import dex.bean.Order;
import dex.main.TaxCalculator;


public class CalculateOrderTest {
	
    private static final HashMap<String, Double> taxes;
    static
    {
    	taxes = new HashMap<String, Double>();
    	taxes.put("1", 1.50);
    	taxes.put("2", 7.65);
        taxes.put("3", 6.70);
    }
	
	@Test
	public void testAll(){
		for (int i = 1; i <4; i++){
			Order order = new Order();
			order.setName("ORDER " + i);
			HashMap<String, BuyedItem> beans = (new BeanFactory(i)).getBeanFactoryMap();
			
			List<BuyedItem> items = new ArrayList<BuyedItem>();
			for (int j = 1; j <= beans.size(); j++)
				items.add(beans.get(String.valueOf(j)));
			
			order.setList(items);
			Assert.assertEquals(taxes.get(String.valueOf(i)).doubleValue(), TaxCalculator.elaborateOrder(order),0);
			
		}
	}
	
//	@Test
//	public void calculateExample1() {
//		
//		// Bean Creation for case 1
//		Order order1 = new Order();
//		order1.setName("ORDER 1");
//		
//		HashMap<String, BuyedItem> beans = (new BeanFactory(1)).getBeanFactoryMap();
//		
//		@SuppressWarnings("serial")
//		List<BuyedItem> items = new ArrayList<BuyedItem>() {{
//			add(beans.get("1"));
//			add(beans.get("2"));
//			add(beans.get("3"));
//		}};
//		
//		order1.setList(items);
//		Assert.assertEquals(1.50, TaxCalculator.elaborateOrder(order1),0);
//		
//	}
//	
//	@Test
//	public void calculateExample2() {
//		
//		// Bean Creation for case 1
//		Order order2 = new Order();
//		order2.setName("ORDER 2");
//		
//		HashMap<String, BuyedItem> beans = (new BeanFactory(2)).getBeanFactoryMap();
//		
//		@SuppressWarnings("serial")
//		List<BuyedItem> items = new ArrayList<BuyedItem>() {{
//			add(beans.get("1"));
//			add(beans.get("2"));
//		}};
//		
//		order2.setList(items);
//		Assert.assertEquals(7.65, TaxCalculator.elaborateOrder(order2),0);
//		
//	}
//	
//	
//	@Test
//	public void calculateExample3() {
//		
//		// Bean Creation for case 1
//		Order order3 = new Order();
//		order3.setName("ORDER 3");
//		
//		HashMap<String, BuyedItem> beans = (new BeanFactory(2)).getBeanFactoryMap();
//
//		@SuppressWarnings("serial")
//		List<BuyedItem> items = new ArrayList<BuyedItem>() {{
//			add(beans.get("1"));
//			add(beans.get("2"));
//			add(beans.get("3"));
//			add(beans.get("4"));
//		}};
//		
//		order3.setList(items);
//		Assert.assertEquals(6.70, TaxCalculator.elaborateOrder(order3),0);
//		
//	}
	

}
