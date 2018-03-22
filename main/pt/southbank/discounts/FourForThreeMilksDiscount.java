package pt.southbank.discounts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import pt.southbank.PricedProduct;

public class FourForThreeMilksDiscount implements Discount {

	@Override
	public BigDecimal apply(List<PricedProduct> itemsInBasket) {

		Optional<PricedProduct> milkOptional = itemsInBasket.stream().findFirst();

		if (!milkOptional.isPresent())
			return new BigDecimal(0);

		long totalMilks = itemsInBasket.stream().filter(x -> x.product().equals("milk")).count();
		BigDecimal freeMilks = new BigDecimal(totalMilks / 4);
		return milkOptional.get().price().multiply(freeMilks);
	}

}
