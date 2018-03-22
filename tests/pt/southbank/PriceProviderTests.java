package pt.southbank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import pt.southbank.exceptions.NoPriceForProduct;

public class PriceProviderTests {
	@Test
	public void priceProviderExists() {
		new StaticPriceProvider(null);
	}

	@Test
	public void priceProviderGetsPriceFromSource() throws NoPriceForProduct {
		Map<String, BigDecimal> priceList = new HashMap<>();
		BigDecimal breadPrice = new BigDecimal(36);
		priceList.put("bread", breadPrice);

		PriceProvider priceProvider = new StaticPriceProvider(priceList);
		BigDecimal price = priceProvider.getPrice("bread");
		assertEquals(breadPrice, price);

		priceList = new HashMap<>();
		breadPrice = new BigDecimal(77);
		priceList.put("bread", breadPrice);

		priceProvider = new StaticPriceProvider(priceList);
		price = priceProvider.getPrice("bread");
		assertEquals(breadPrice, price);
	}

	@Test
	public void productNotPriced() {
		Map<String, BigDecimal> priceList = new HashMap<>();
		BigDecimal milkPrice = new BigDecimal(77.4);
		priceList.put("milk", milkPrice);
		PriceProvider priceProvider = new StaticPriceProvider(priceList);
		assertThrows(NoPriceForProduct.class, () -> priceProvider.getPrice("butter"));
	}
}
