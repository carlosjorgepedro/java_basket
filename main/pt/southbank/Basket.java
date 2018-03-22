package pt.southbank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pt.southbank.exceptions.InvalidProduct;
import pt.southbank.exceptions.NoPriceForProduct;

public class Basket {
	private List<BasketItem> items;
	private PriceProvider priceProvider;

	public Basket(PriceProvider priceProvider) {
		this.priceProvider = priceProvider;
		this.items = new ArrayList<>();
	}

	public void add(String product) throws InvalidProduct {
		try {
			BigDecimal price = priceProvider.getPrice(product);
			items.add(new BasketItem(product, price));
		} catch (NoPriceForProduct exception) {
			throw new InvalidProduct(product);
		}
	}

	public List<BasketItem> get() {
		return items;
	}

	public BigDecimal total() {
		BigDecimal total = new BigDecimal(0);

		for (BasketItem itemInBasket : items) {
			total = total.add(itemInBasket.price());
		}
		return total;
	}
}
