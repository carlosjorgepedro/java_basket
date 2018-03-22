package pt.southbank;

import java.math.BigDecimal;
import java.util.UUID;

import pt.southbank.exceptions.NoPriceForProduct;

class FakePriceProvider implements PriceProvider {
	public static final String ProductWithoutPrice = UUID.randomUUID().toString();
	private BigDecimal price;

	public FakePriceProvider() {
		this.price = new BigDecimal(0);
	}

	public FakePriceProvider(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice(String product) throws NoPriceForProduct {
		if (product.equals(FakePriceProvider.ProductWithoutPrice)) {
			throw new NoPriceForProduct();
		}
		return price;
	}
}