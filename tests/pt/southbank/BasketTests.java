package pt.southbank;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;




public class BasketTests {

	@Test public void testAddItemToBasket() {
		Basket basket = new Basket();
		String product = "butter";
		basket.add(product);
		
		List<String> productsInBasket =  basket.get();
		assertEquals( 1, productsInBasket.size());
		assertEquals(product, productsInBasket.get(0));
	}
}
