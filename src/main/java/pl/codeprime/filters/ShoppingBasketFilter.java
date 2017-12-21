/**
 * 
 */
package pl.codeprime.filters;

import java.util.function.Predicate;

import pl.codeprime.repositories.entity.bills.shopping.ShoppingBasket;

/**
 * @author MOwsians
 *
 */
public class ShoppingBasketFilter {

	
	public static Predicate<ShoppingBasket> NAME_AND_DEPARTMENT(ShoppingBasket pattern) {
		return new Predicate<ShoppingBasket>() {

			@Override
			public boolean test(ShoppingBasket t) {
				
				/*boolean equals = pattern.getName().equals(t.get) 
								 && pattern.getDepartment().equals(t.getDepartment());*/
				return true;
			}
		};
	}
	
	public static Predicate<ShoppingBasket> NAME(ShoppingBasket pattern) {
		return new Predicate<ShoppingBasket>() {

			@Override
			public boolean test(ShoppingBasket t) {
				/*return pattern.getName().equals(t.getName())*/;
				return true;
			}
		};
	}
}
