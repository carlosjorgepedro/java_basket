package pt.southbank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {
	private List<BasketItem> items;

	public Basket() {
		this.items = new ArrayList<>();
	}

	public void add(String product) {
		items.add(new BasketItem(product, new BigDecimal(10)));
	}

	public List<BasketItem> get() {
		return items;
	}

}
