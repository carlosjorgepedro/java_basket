package pt.southbank.discounts;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pt.southbank.PricedProduct;

public class CumulativeDiscountTests {

	@Test
	public void appliesInnerDiscounts() {
		List<ZeroDiscountProvider> discounts = new ArrayList<ZeroDiscountProvider>();
		discounts.add(new ZeroDiscountProvider());
		discounts.add(new ZeroDiscountProvider());
		
		Discount cumulativeDiscount = new CumulativeDiscount(discounts);
		
		for(ZeroDiscountProvider discount : discounts) {
			assertFalse(discount.applied());
		}
		
		cumulativeDiscount.apply(new ArrayList<PricedProduct>());
		
		for(ZeroDiscountProvider discount : discounts) {
			assertTrue(discount.applied());
		}
	}
}
