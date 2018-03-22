package pt.southbank;

import java.math.BigDecimal;

public interface PriceProvider {
	public BigDecimal getPrice(String product) throws NoPriceForProduct;
}
