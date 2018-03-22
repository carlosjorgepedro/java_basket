package pt.southbank;

import java.math.BigDecimal;
import java.util.List;

public interface Discount {
	public BigDecimal apply(List<BasketItem> itemsInBasket);
}
