package dex.bean;

import java.util.HashMap;

public class BeanFactory {

	private HashMap<String, BuyedItem> beanFactoryMap;

	private final static int TEST_CASE_1 = 1;
	private final static int TEST_CASE_2 = 2;
	private final static int TEST_CASE_3 = 3;


	public HashMap<String, BuyedItem> getBeanFactoryMap() {
		return beanFactoryMap;
	}

	public void setBeanFactoryMap(HashMap<String, BuyedItem> beanFactoryMap) {
		this.beanFactoryMap = beanFactoryMap;
	}

	public BeanFactory(int test_case) {
		beanFactoryMap = new HashMap<String, BuyedItem>();
		switch (test_case) {
		case 	TEST_CASE_1: populateMapCaseOne();
		break;
		case 	TEST_CASE_2: populateMapCaseTwo();
		break;
		case 	TEST_CASE_3: populateMapCaseThree();
		break;
		default:
			break;
		}
	}

	private void populateMapCaseOne(){

		// CASE 1
		BuyedItem book = new BuyedItem();
		book.setName("Book");
		book.setPrice(12.49);
		book.setType("0");
		book.setImported(false);
		book.setQuantity(1);
		beanFactoryMap.put("1", book);

		BuyedItem musicCD = new BuyedItem();
		musicCD.setName("Music CD");
		musicCD.setPrice(14.99);
		musicCD.setType("1");
		musicCD.setImported(false);
		musicCD.setQuantity(1);
		beanFactoryMap.put("2", musicCD);

		BuyedItem chocolateBar = new BuyedItem();
		chocolateBar.setName("Chocolate Bar");
		chocolateBar.setPrice(0.85);
		chocolateBar.setType("0");
		chocolateBar.setImported(false);
		chocolateBar.setQuantity(1);
		beanFactoryMap.put("3", chocolateBar);

	}

	private void populateMapCaseTwo(){

		//CASE 2
		BuyedItem choco = new BuyedItem();
		choco.setName("Imported Box of Chocolate");
		choco.setPrice(10.00);
		choco.setType("0");
		choco.setImported(true);
		choco.setQuantity(1);
		beanFactoryMap.put("1", choco);

		BuyedItem parfume = new BuyedItem();
		parfume.setName("Imported Bottle of Parfume");
		parfume.setPrice(47.50);
		parfume.setType("1");
		parfume.setImported(true);
		parfume.setQuantity(1);
		beanFactoryMap.put("2", parfume);

	}

	private void populateMapCaseThree(){

		//CASE 3
		BuyedItem parfume1 = new BuyedItem();
		parfume1.setName("Imported Bottle of Parfume");
		parfume1.setPrice(27.99);
		parfume1.setType("1");
		parfume1.setImported(true);
		parfume1.setQuantity(1);
		beanFactoryMap.put("1", parfume1);

		BuyedItem parfume2 = new BuyedItem();
		parfume2.setName("Bottle of Parfume");
		parfume2.setPrice(18.99);
		parfume2.setType("1");
		parfume2.setImported(false);
		parfume2.setQuantity(1);
		beanFactoryMap.put("2", parfume2);

		BuyedItem pills = new BuyedItem();
		pills.setName("Headache Pills");
		pills.setPrice(9.75);
		pills.setType("0");
		pills.setImported(false);
		pills.setQuantity(1);
		beanFactoryMap.put("3", pills);

		BuyedItem choco2 = new BuyedItem();
		choco2.setName("Imported Box of Chocolate");
		choco2.setPrice(11.25);
		choco2.setType("0");
		choco2.setImported(true);
		choco2.setQuantity(1);
		beanFactoryMap.put("4", choco2);

	}

}
