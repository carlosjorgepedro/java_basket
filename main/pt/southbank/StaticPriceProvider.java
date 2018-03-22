package pt.southbank;

import java.math.BigDecimal;
import java.util.Map;

import pt.southbank.exceptions.NoPriceForProduct;

class StaticPriceProvider implements PriceProvider {
	private Map<String, BigDecimal> priceList;

	public StaticPriceProvider(Map<String, BigDecimal> priceList) {
		this.priceList = priceList;
	}

	public BigDecimal getPrice(String product) throws NoPriceForProduct {
		if (priceList.containsKey(product)) {
			return priceList.get(product);
		}
		throw new NoPriceForProduct();
	}

}
