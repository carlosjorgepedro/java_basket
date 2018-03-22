package pt.southbank.discounts;

import java.math.BigDecimal;
import java.util.List;

import pt.southbank.PricedProduct;
import pt.southbank.discounts.Discount;

public class TenPercentFlatDiscountProvider implements Discount {
	private static final BigDecimal flatDiscount = new BigDecimal("0.10");

	public BigDecimal apply(List<PricedProduct> itemsInBasket) {
		BigDecimal totalDiscount = new BigDecimal(0);

		for (PricedProduct item : itemsInBasket) {
			totalDiscount = flatDiscount.multiply(item.price());
		}

		return totalDiscount;
	}

}
