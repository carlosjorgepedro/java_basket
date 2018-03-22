package pt.southbank;

import java.math.BigDecimal;

class FakePriceProvider implements PriceProvider {
	private BigDecimal price;

	public FakePriceProvider(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice(String product) {
		return price;
	}
}