package pt.southbank.discounts;

import java.math.BigDecimal;
import java.util.List;

import pt.southbank.PricedProduct;
import pt.southbank.discounts.Discount;

public class ZeroDiscountProvider implements Discount {
	boolean applied = false;

	public boolean applied() {
		return applied;
	}

	@Override
	public BigDecimal apply(List<PricedProduct> itemsInBasket) {
		applied = true;
		return new BigDecimal(0);
	}

}
