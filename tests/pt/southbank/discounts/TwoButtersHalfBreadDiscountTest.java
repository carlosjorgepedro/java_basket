package pt.southbank.discounts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import pt.southbank.PricedProduct;

public class TwoButtersHalfBreadDiscountTest {

	@Test
	public void emptyBasket() {
		BigDecimal expectedTotalDiscount = new BigDecimal(0);
		Discount discount = new TwoButtersHalfBreadDiscount();
		BigDecimal discountTotal = discount.apply(new ArrayList<PricedProduct>());

		assertEquals(0, discountTotal.compareTo(expectedTotalDiscount));
	}

	@Test
	public void buttersButNoBread() {
		BigDecimal expectedTotalDiscount = new BigDecimal(0);
		BigDecimal butterPrice = new BigDecimal("2.44");
		List<PricedProduct> itemsInBasket = new ArrayList<PricedProduct>();
		for (int i = 0; i < 12; i++) {
			itemsInBasket.add(new PricedProduct("butter", butterPrice));
		}

		Discount discount = new TwoButtersHalfBreadDiscount();
		BigDecimal discountTotal = discount.apply(itemsInBasket);
		assertEquals(0, discountTotal.compareTo(expectedTotalDiscount));
	}

	@Test
	public void breadButNoButter() {
		BigDecimal expectedTotalDiscount = new BigDecimal(0);
		BigDecimal breadPrice = new BigDecimal("4.44");
		List<PricedProduct> itemsInBasket = new ArrayList<PricedProduct>();
		for (int i = 0; i < 12; i++) {
			itemsInBasket.add(new PricedProduct("bread", breadPrice));
		}

		Discount discount = new TwoButtersHalfBreadDiscount();
		BigDecimal discountTotal = discount.apply(itemsInBasket);
		assertEquals(0, discountTotal.compareTo(expectedTotalDiscount));
	}

	@Test
	public void twoButterOneBread() {

		BigDecimal breadPrice = new BigDecimal("1.00");
		BigDecimal butterPrice = new BigDecimal("1.00");

		BigDecimal expectedTotalDiscount = breadPrice.divide(new BigDecimal(2));

		List<PricedProduct> itemsInBasket = new ArrayList<PricedProduct>();
		itemsInBasket.add(new PricedProduct("butter", butterPrice));
		itemsInBasket.add(new PricedProduct("butter", butterPrice));

		itemsInBasket.add(new PricedProduct("bread", breadPrice));

		Discount discount = new TwoButtersHalfBreadDiscount();
		BigDecimal discountTotal = discount.apply(itemsInBasket);
		assertEquals(0, discountTotal.compareTo(expectedTotalDiscount));
	}

	@Test
	public void OneButterOneBread() {

		BigDecimal breadPrice = new BigDecimal("6.10");
		BigDecimal butterPrice = new BigDecimal("2.00");

		BigDecimal expectedTotalDiscount = new BigDecimal(0);

		List<PricedProduct> itemsInBasket = new ArrayList<PricedProduct>();
		itemsInBasket.add(new PricedProduct("butter", butterPrice));

		itemsInBasket.add(new PricedProduct("bread", breadPrice));

		Discount discount = new TwoButtersHalfBreadDiscount();
		BigDecimal discountTotal = discount.apply(itemsInBasket);
		assertEquals(0, discountTotal.compareTo(expectedTotalDiscount));
	}
	
	@Test
	public void FourButterOneBread() {

		BigDecimal breadPrice = new BigDecimal("10");
		BigDecimal butterPrice = new BigDecimal("0.1");

		BigDecimal expectedTotalDiscount = new BigDecimal(5);

		List<PricedProduct> itemsInBasket = new ArrayList<PricedProduct>();
		
		itemsInBasket.add(new PricedProduct("butter", butterPrice));
		itemsInBasket.add(new PricedProduct("butter", butterPrice));
		itemsInBasket.add(new PricedProduct("butter", butterPrice));
		itemsInBasket.add(new PricedProduct("butter", butterPrice));
		
		itemsInBasket.add(new PricedProduct("bread", breadPrice));

		Discount discount = new TwoButtersHalfBreadDiscount();
		BigDecimal discountTotal = discount.apply(itemsInBasket);
		assertEquals(0, discountTotal.compareTo(expectedTotalDiscount), String.format("expected %s but value was %s", expectedTotalDiscount, discountTotal));
	}
	
	
	@Test
	public void FourButterTwoBread() {

		BigDecimal breadPrice = new BigDecimal("25");
		BigDecimal butterPrice = new BigDecimal("11");

		BigDecimal expectedTotalDiscount = new BigDecimal(25);

		List<PricedProduct> itemsInBasket = new ArrayList<PricedProduct>();
		
		itemsInBasket.add(new PricedProduct("butter", butterPrice));
		itemsInBasket.add(new PricedProduct("butter", butterPrice));
		itemsInBasket.add(new PricedProduct("butter", butterPrice));
		itemsInBasket.add(new PricedProduct("butter", butterPrice));
		
		itemsInBasket.add(new PricedProduct("bread", breadPrice));
		itemsInBasket.add(new PricedProduct("bread", breadPrice));

		Discount discount = new TwoButtersHalfBreadDiscount();
		BigDecimal discountTotal = discount.apply(itemsInBasket);
		assertEquals(0, discountTotal.compareTo(expectedTotalDiscount), String.format("expected %s but value was %s", expectedTotalDiscount, discountTotal));
	}
}
