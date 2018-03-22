package pt.southbank;

import java.math.BigDecimal;

public class FakePriceProvider implements PriceProvider {
	private BigDecimal price;

	public FakePriceProvider(BigDecimal price) {
		this.price=price;
	}

	@Override
	public BigDecimal getPrice(String product) {
		return price;
	}
}
