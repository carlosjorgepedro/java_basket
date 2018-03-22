package pt.southbank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BasketTests {
	@Test
	public void addItemToBasket() {
		Basket basket = new Basket();
		String product = "butter";
		basket.add(product);

		List<BasketItem> productsInBasket = basket.get();
		assertEquals(1, productsInBasket.size());
		assertEquals(product, productsInBasket.get(0).product());
	}

	@Test
	public void addMultipleItemsToBasket() {
		Basket basket = new Basket();
		List<String> productList = new ArrayList<String>();
		productList.add("butter");
		productList.add("milk");
		productList.add("bread");

		for (String product : productList) {
			basket.add(product);
		}

		List<BasketItem> productsInBasket = basket.get();
		assertEquals(3, productsInBasket.size());

		for (BasketItem itemInBasket : productsInBasket) {
			assertTrue(productList.contains(itemInBasket.product()));
		}
	}

	@Test
	public void addSameProductsMultipleTimes() {
		Basket basket = new Basket();
		List<String> productList = new ArrayList<String>();
		productList.add("butter");
		productList.add("butter");
		productList.add("butter");
		productList.add("butter");

		for (String product : productList) {
			basket.add(product);
		}

		List<BasketItem> productsInBasket = basket.get();
		assertEquals(4, productsInBasket.size());
	}

	@Test
	public void itemsInBasketHavePrice() {
		Basket basket = new Basket();
		List<String> productList = new ArrayList<String>();
		productList.add("butter");

		for (String product : productList) {
			basket.add(product);
		}

		List<BasketItem> products = basket.get();
		BasketItem basketItem = products.get(0);
		assertEquals(new BigDecimal(10), basketItem.price());
	}
}
