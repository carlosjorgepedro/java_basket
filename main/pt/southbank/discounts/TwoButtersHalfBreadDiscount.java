package pt.southbank.discounts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import pt.southbank.PricedProduct;

public class TwoButtersHalfBreadDiscount implements Discount {

	public BigDecimal apply(List<PricedProduct> itemsInBasket) {
		Optional<PricedProduct> optionalBread = itemsInBasket.stream().filter(x -> x.product().equals("bread"))
				.findFirst();

		long butterCount = itemsInBasket.stream().filter(x -> x.product().equals("butter")).count();

		if (optionalBread.isPresent() && butterCount > 1) {
			long maxBreadsWithDiscount = butterCount / 2;
			long totalBreads = itemsInBasket.stream().filter(x -> x.product().equals("bread")).count();

			long breadWithDiscount = totalBreads < maxBreadsWithDiscount ? totalBreads : maxBreadsWithDiscount;
			
			return optionalBread.get().price().divide(new BigDecimal(2)).multiply(new BigDecimal(breadWithDiscount));
		}

		return new BigDecimal(0);
	}

}
