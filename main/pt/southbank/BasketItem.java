package pt.southbank;

import java.math.BigDecimal;

public class BasketItem {
	private String product;
	private BigDecimal price;

	public BasketItem(String product, BigDecimal price) {
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
