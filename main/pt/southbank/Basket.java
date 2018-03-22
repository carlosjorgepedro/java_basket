package pt.southbank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pt.southbank.discounts.Discount;
import pt.southbank.exceptions.InvalidProduct;
import pt.southbank.exceptions.NoPriceForProduct;

public class Basket {
	private List<PricedProduct> items;
	private PriceProvider priceProvider;
	private Discount discountProvider;

	public Basket(PriceProvider priceProvider, Discount discountProvider) {
		this.priceProvider = priceProvider;
		this.discountProvider = discountProvider;
		this.items = new ArrayList<>();
	}

	public void add(String product) throws InvalidProduct {
		try {
			BigDecimal price = priceProvider.getPrice(product);
			items.add(new PricedProduct(product, price));
		} catch (NoPriceForProduct exception) {
			throw new InvalidProduct(product);
		}
	}

	public List<PricedProduct> get() {
		return items;
	}

	public BigDecimal total() {
		BigDecimal total = new BigDecimal(0);		
		BigDecimal discount = discountProvider.apply(items);	
		
		for (PricedProduct itemInBasket : items) {
			total = total.add(itemInBasket.price());
		}
		return total.subtract(discount);
	}
}
