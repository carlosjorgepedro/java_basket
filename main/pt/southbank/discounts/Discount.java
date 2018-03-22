package pt.southbank.discounts;

import java.math.BigDecimal;
import java.util.List;

import pt.southbank.BasketItem;

public interface Discount {
	public BigDecimal apply(List<BasketItem> itemsInBasket);
}
