package pt.southbank;

import java.math.BigDecimal;
import java.util.List;

public class ZeroDiscountProvider implements Discount {

	@Override
	public BigDecimal apply(List<BasketItem> itemsInBasket) {
		return new BigDecimal(0);
	}

}
