package pt.southbank;

import java.math.BigDecimal;
import java.util.List;

import pt.southbank.discounts.Discount;

public class ZeroDiscountProvider implements Discount {
	boolean applied = false;

	public boolean applied() {
		return applied;
	}

	@Override
	public BigDecimal apply(List<BasketItem> itemsInBasket) {
		applied = true;
		return new BigDecimal(0);
	}

}
