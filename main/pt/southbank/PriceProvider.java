package pt.southbank;

import java.math.BigDecimal;

interface PriceProvider {
	public BigDecimal getPrice(String product) throws NoPriceForProduct;
}
