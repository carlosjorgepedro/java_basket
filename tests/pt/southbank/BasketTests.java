package pt.southbank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import pt.southbank.discounts.Discount;
import pt.southbank.exceptions.InvalidProduct;

public class BasketTests {
	@Test
	public void basketWithoutItemHasATotalOfZero() {
		FakePriceProvider priceProvider = new FakePriceProvider();
		TenPercentFlatDiscountProvider discount = new TenPercentFlatDiscountProvider();
		Basket basket = new Basket(priceProvider, discount);
		assertEquals(new BigDecimal(0), basket.total());
	}

	@Test
	public void addItemToBasket() throws InvalidProduct {
		FakePriceProvider priceProvider = new FakePriceProvider();
		TenPercentFlatDiscountProvider discount = new TenPercentFlatDiscountProvider();
		Basket basket = new Basket(priceProvider, discount);
		String product = "butter";
		basket.add(product);

		List<BasketItem> productsInBasket = basket.get();
		assertEquals(1, productsInBasket.size());
		assertEquals(product, productsInBasket.get(0).product());
	}

	@Test
	public void addMultipleItemsToBasket() throws InvalidProduct {
		FakePriceProvider priceProvider = new FakePriceProvider();
		TenPercentFlatDiscountProvider discount = new TenPercentFlatDiscountProvider();
		Basket basket = new Basket(priceProvider, discount);
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
	public void addSameProductsMultipleTimes() throws InvalidProduct {
		FakePriceProvider priceProvider = new FakePriceProvider();
		TenPercentFlatDiscountProvider discount = new TenPercentFlatDiscountProvider();
		Basket basket = new Basket(priceProvider, discount);
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
	public void itemsInBasketHavePrice() throws InvalidProduct {
		FakePriceProvider priceProvider = new FakePriceProvider(new BigDecimal(10));
		TenPercentFlatDiscountProvider discount = new TenPercentFlatDiscountProvider();
		Basket basket = new Basket(priceProvider, discount);
		List<String> productList = new ArrayList<String>();
		productList.add("butter");

		for (String product : productList) {
			basket.add(product);
		}

		List<BasketItem> products = basket.get();
		BasketItem basketItem = products.get(0);
		assertEquals(0, new BigDecimal(10).compareTo(basketItem.price()));
	}

	@Test
	public void itemPriceCamesFromPriceProvider() throws InvalidProduct {
		BigDecimal productPrice = new BigDecimal(11);
		FakePriceProvider priceProvider = new FakePriceProvider(productPrice);
		TenPercentFlatDiscountProvider discount = new TenPercentFlatDiscountProvider();
		Basket basket = new Basket(priceProvider, discount);
		basket.add("butter");

		BasketItem basketItem = basket.get().get(0);
		assertEquals(0, productPrice.compareTo(basketItem.price()));
	}

	@Test
	public void totalHasTheTotalPriceofAllItemsInBasket() throws InvalidProduct {
		FakePriceProvider priceProvider = new FakePriceProvider(new BigDecimal(5));
		Discount discount = new ZeroDiscountProvider();
		Basket basket = new Basket(priceProvider, discount);
		List<String> productList = new ArrayList<String>();
		productList.add("butter");
		productList.add("milk");
		productList.add("bread");

		for (String product : productList) {
			basket.add(product);
		}
		assertEquals(0, new BigDecimal(15).compareTo(basket.total()));
	}

	@Test
	public void basketThrowsIfProductHasNotPrice() {
		FakePriceProvider priceProvider = new FakePriceProvider();
		TenPercentFlatDiscountProvider discount = new TenPercentFlatDiscountProvider();
		Basket basket = new Basket(priceProvider, discount);
		assertThrows(InvalidProduct.class, () -> basket.add(FakePriceProvider.ProductWithoutPrice));
	}

	@Test
	public void basketExceptionSpecifyFailedProduct() {
		FakePriceProvider priceProvider = new FakePriceProvider();
		TenPercentFlatDiscountProvider discount = new TenPercentFlatDiscountProvider();
		Basket basket = new Basket(priceProvider, discount);
		InvalidProduct thrownException = assertThrows(InvalidProduct.class,
				() -> basket.add(FakePriceProvider.ProductWithoutPrice));
		assertEquals(FakePriceProvider.ProductWithoutPrice, thrownException.product());
	}

	@Test
	public void totalHasAppliedDiscounts() throws InvalidProduct {
		FakePriceProvider priceProvider = new FakePriceProvider(new BigDecimal("100"));
		TenPercentFlatDiscountProvider discount = new TenPercentFlatDiscountProvider();
		Basket basket = new Basket(priceProvider, discount);
		basket.add("milk");
		assertEquals(0, new BigDecimal("90").compareTo(basket.total()));

	}
}
