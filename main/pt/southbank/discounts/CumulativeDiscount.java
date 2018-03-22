package pt.southbank.discounts;

import java.math.BigDecimal;
import java.util.List;

import pt.southbank.PricedProduct;

public class CumulativeDiscount implements Discount {
	private List<ZeroDiscountProvider> discounts;

	public CumulativeDiscount(List<ZeroDiscountProvider> discounts) {
		this.discounts = discounts;
	}


	public BigDecimal apply(List<PricedProduct> itemsInBasket) {
		BigDecimal totalDiscount = new BigDecimal(0);

		for (Discount discount : discounts) {
			totalDiscount = totalDiscount.add(discount.apply(itemsInBasket));
		}

		return totalDiscount;
	}

}
