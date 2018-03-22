package pt.southbank;

import java.math.BigDecimal;
import java.util.List;

public class TenPercentFlatDiscountProvider implements Discount {
	private static final BigDecimal flatDiscount = new BigDecimal("0.10");

	public BigDecimal apply(List<BasketItem> itemsInBasket) {
		BigDecimal totalDiscount = new BigDecimal(0);

		for (BasketItem item : itemsInBasket) {
			totalDiscount = flatDiscount.multiply(item.price());
		}

		return totalDiscount;
	}

}
