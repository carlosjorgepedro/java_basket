package pt.southbank.discounts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import pt.southbank.PricedProduct;

public class FourForThreeMilksDiscountTest {
	@Test
	public void discountExists() {
		new FourForThreeMilksDiscount();
	}

	@Test
	public void noItemsInBasket() {
		Discount discount = new FourForThreeMilksDiscount();
		List<PricedProduct> itemsInBasket = new ArrayList<PricedProduct>();
		BigDecimal discountTotal = discount.apply(itemsInBasket);

		assertEquals(0, discountTotal.compareTo(new BigDecimal(0)));
	}

	@Test
	public void noMilkInBasketInBasket() {
		Discount discount = new FourForThreeMilksDiscount();
		List<PricedProduct> itemsInBasket = new ArrayList<PricedProduct>();

		for (int i = 0; i < 15; i++) {
			itemsInBasket.add(new PricedProduct("butter", new BigDecimal("1.01")));
		}

		BigDecimal discountTotal = discount.apply(itemsInBasket);
		
		assertEquals(0, discountTotal.compareTo(new BigDecimal(0)));
	}
	
	@Test
	public void fourMilksInBasket() {
		Discount discount = new FourForThreeMilksDiscount();
		List<PricedProduct> itemsInBasket = new ArrayList<PricedProduct>();

		for (int i = 0; i < 4; i++) {
			itemsInBasket.add(new PricedProduct("milk", new BigDecimal("4.10")));
		}

		BigDecimal discountTotal = discount.apply(itemsInBasket);

		assertEquals(0, discountTotal.compareTo(new BigDecimal("4.10")));
	}
	
	@Test
	public void eightMilksInBasket() {
		Discount discount = new FourForThreeMilksDiscount();
		List<PricedProduct> itemsInBasket = new ArrayList<PricedProduct>();

		for (int i = 0; i < 8; i++) {
			itemsInBasket.add(new PricedProduct("milk", new BigDecimal("3.1")));
		}

		BigDecimal discountTotal = discount.apply(itemsInBasket);

		assertEquals(0, discountTotal.compareTo(new BigDecimal("6.20")));
	}
}
