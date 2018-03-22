package pt.southbank;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;




public class BasketTests {
	@Test public void addItemToBasket() {
		Basket basket = new Basket();
		String product = "butter";
		basket.add(product);
		
		List<String> productsInBasket =  basket.get();
		assertEquals( 1, productsInBasket.size());
		assertEquals(product, productsInBasket.get(0));
	}
	
	@Test public void addMultipleItemsToBasket() {
		Basket basket = new Basket();
		List<String> productList = new ArrayList<String>();
		productList.add("butter");
		productList.add("milk");
		productList.add("bread");
					
		for(String product : productList) {
			basket.add(product);
		}
		
		List<String> productsInBasket = basket.get();
		assertEquals( 3, productsInBasket.size());
	
		for(String product : productList) {
			assertTrue(productsInBasket.contains(product));
		}
	}
}
