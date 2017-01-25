package dex.bean;

import java.util.HashMap;

import dex.util.Constants;

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

	/**
	 * Depending on test_case parameter, this factory create a specific input test case (one of the three available).
	 * After this constructor, hashmap beanFactoryMap will contains all data necessary to test execution.
	 * @param test_case
	 */
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
		book.setName(Constants.BOOK);
		book.setPrice(12.49);
		book.setType(Constants.NO_TAXED_ITEM);
		book.setImported(false);
		book.setQuantity(1);
		beanFactoryMap.put("1", book);

		BuyedItem musicCD = new BuyedItem();
		musicCD.setName(Constants.MUSIC_CD);
		musicCD.setPrice(14.99);
		musicCD.setType(Constants.TAXED_ITEM);
		musicCD.setImported(false);
		musicCD.setQuantity(1);
		beanFactoryMap.put("2", musicCD);

		BuyedItem chocolateBar = new BuyedItem();
		chocolateBar.setName(Constants.CHOCOLATE_BAR);
		chocolateBar.setPrice(0.85);
		chocolateBar.setType(Constants.NO_TAXED_ITEM);
		chocolateBar.setImported(false);
		chocolateBar.setQuantity(1);
		beanFactoryMap.put("3", chocolateBar);

	}

	private void populateMapCaseTwo(){

		//CASE 2
		BuyedItem choco = new BuyedItem();
		choco.setName(Constants.IMPORTED_CHOCOLATE);
		choco.setPrice(10.00);
		choco.setType(Constants.NO_TAXED_ITEM);
		choco.setImported(true);
		choco.setQuantity(1);
		beanFactoryMap.put("1", choco);

		BuyedItem parfume = new BuyedItem();
		parfume.setName(Constants.IMPORTED_PARFUME);
		parfume.setPrice(47.50);
		parfume.setType(Constants.TAXED_ITEM);
		parfume.setImported(true);
		parfume.setQuantity(1);
		beanFactoryMap.put("2", parfume);

	}

	private void populateMapCaseThree(){

		//CASE 3
		BuyedItem parfume1 = new BuyedItem();
		parfume1.setName(Constants.IMPORTED_PARFUME);
		parfume1.setPrice(27.99);
		parfume1.setType(Constants.TAXED_ITEM);
		parfume1.setImported(true);
		parfume1.setQuantity(1);
		beanFactoryMap.put("1", parfume1);

		BuyedItem parfume2 = new BuyedItem();
		parfume2.setName(Constants.PARFUME);
		parfume2.setPrice(18.99);
		parfume2.setType(Constants.TAXED_ITEM);
		parfume2.setImported(false);
		parfume2.setQuantity(1);
		beanFactoryMap.put("2", parfume2);

		BuyedItem pills = new BuyedItem();
		pills.setName(Constants.PILLS);
		pills.setPrice(9.75);
		pills.setType(Constants.NO_TAXED_ITEM);
		pills.setImported(false);
		pills.setQuantity(1);
		beanFactoryMap.put("3", pills);

		BuyedItem choco2 = new BuyedItem();
		choco2.setName(Constants.IMPORTED_CHOCOLATE);
		choco2.setPrice(11.25);
		choco2.setType(Constants.NO_TAXED_ITEM);
		choco2.setImported(true);
		choco2.setQuantity(1);
		beanFactoryMap.put("4", choco2);

	}

}
