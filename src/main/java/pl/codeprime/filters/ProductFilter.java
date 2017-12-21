/**
 * 
 */
package pl.codeprime.filters;

import java.util.function.Predicate;

import pl.codeprime.repositories.entity.bills.shopping.Product;

/**
 * @author MOwsians
 *
 */
public class ProductFilter {
	
	
	public static Predicate<Product> NAME_AND_DEPARTMENT(Product pattern) {
		return new Predicate<Product>() {

			@Override
			public boolean test(Product t) {
				
				boolean equals = pattern.getName().equals(t.getName()) 
								 && pattern.getDepartment().equals(t.getDepartment());
				return equals;
			}
		};
	}
	
	public static Predicate<Product> NAME(Product pattern) {
		return new Predicate<Product>() {

			@Override
			public boolean test(Product t) {
				return pattern.getName().equals(t.getName());
			}
		};
	}
	
	
}
