package pt.southbank;

import java.math.BigDecimal;

import pt.southbank.exceptions.NoPriceForProduct;

interface PriceProvider {
	public BigDecimal getPrice(String product) throws NoPriceForProduct;
}
