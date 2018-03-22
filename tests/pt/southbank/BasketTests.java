package pt.southbank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BasketTests {
	@Test
	public void addItemToBasket() throws NoPriceForProduct {
		FakePriceProvider priceProvider = new FakePriceProvider(new BigDecimal(11));
		Basket basket = new Basket(priceProvider);
		String product = "butter";
		basket.add(product);

		List<BasketItem> productsInBasket = basket.get();
		assertEquals(1, productsInBasket.size());
		assertEquals(product, productsInBasket.get(0).product());
	}

	@Test
	public void addMultipleItemsToBasket() throws NoPriceForProduct {
		FakePriceProvider priceProvider = new FakePriceProvider(new BigDecimal(11));
		Basket basket = new Basket(priceProvider);
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
	public void addSameProductsMultipleTimes() throws NoPriceForProduct {
		FakePriceProvider priceProvider = new FakePriceProvider(new BigDecimal(11));
		Basket basket = new Basket(priceProvider);
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
	public void itemsInBasketHavePrice() throws NoPriceForProduct {
		FakePriceProvider priceProvider = new FakePriceProvider(new BigDecimal(10));
		Basket basket = new Basket(priceProvider);
		List<String> productList = new ArrayList<String>();
		productList.add("butter");

		for (String product : productList) {
			basket.add(product);
		}

		List<BasketItem> products = basket.get();
		BasketItem basketItem = products.get(0);
		assertEquals(new BigDecimal(10), basketItem.price());
	}

	@Test
	public void itemPriceCamesFromPriceProvider() throws NoPriceForProduct {
		BigDecimal productPrice = new BigDecimal(11);
		FakePriceProvider priceProvider = new FakePriceProvider(productPrice);
		Basket basket = new Basket(priceProvider);
		basket.add("butter");

		BasketItem basketItem = basket.get().get(0);
		assertEquals(productPrice, basketItem.price());
	}

	@Test
	public void basketHasTotal() {
		Basket basket = new Basket(null);
		basket.total();
	}

	@Test
	public void totalHasTheTotalPriceofAllItemsInBasket() throws NoPriceForProduct {
		FakePriceProvider priceProvider = new FakePriceProvider(new BigDecimal(5));
		Basket basket = new Basket(priceProvider);
		List<String> productList = new ArrayList<String>();
		productList.add("butter");
		productList.add("milk");
		productList.add("bread");

		for (String product : productList) {
			basket.add(product);
		}

		assertEquals(new BigDecimal(15), basket.total());
	}
}
