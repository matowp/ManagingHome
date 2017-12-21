/**
 * 
 */
package pl.codeprime.common.functions;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import pl.codeprime.repositories.entity.bills.shopping.ShoppingBasket;
import pl.codeprime.webservices.rest.response.BoughtProductResponse;
import pl.codeprime.webservices.rest.response.ShoppingBasketResponse;

/**
 * @author MOwsians
 *
 */
public class ShoppingBasketFunction {

	public static Function<ShoppingBasket, ShoppingBasketResponse> TO_RESPONSE = 
			new Function<ShoppingBasket, ShoppingBasketResponse>() {

		@Override
		public ShoppingBasketResponse apply(ShoppingBasket t) {
			
			ShoppingBasketResponse response = new ShoppingBasketResponse();
			

			List<BoughtProductResponse> collect = t.getProducts()
																.stream()
																	.map(BoughtProductFunction.TO_RESPONSE)
																		.collect(Collectors.toList());
			
			response.setBoughtProducts(collect);
			response.setShopName(t.getShopName());
			
			return response;
		}
	};

}
