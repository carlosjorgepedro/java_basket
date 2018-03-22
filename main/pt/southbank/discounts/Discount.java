package pt.southbank.discounts;

import java.math.BigDecimal;
import java.util.List;

import pt.southbank.PricedProduct;

public interface Discount {
	public BigDecimal apply(List<PricedProduct> itemsInBasket);
}
