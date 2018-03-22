package pt.southbank;

import java.math.BigDecimal;

public class PricedProduct {
	private String product;
	private BigDecimal price;

	public PricedProduct(String product, BigDecimal price) {
		this.product = product;
		this.price = price;
	}

	public BigDecimal price() {
		return price;
	}

	public String product() {
		return product;
	}
}
