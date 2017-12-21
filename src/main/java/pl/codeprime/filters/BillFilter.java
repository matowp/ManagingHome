/**
 * 
 */
package pl.codeprime.filters;

import java.util.function.Predicate;

import pl.codeprime.converters.BillConverterEnum;

/**
 * @author MOwsians
 *
 */
public class BillFilter {
	
	
	public static Predicate<BillConverterEnum> TYPE_NAME(String type) {
		return new Predicate<BillConverterEnum>() {

			@Override
			public boolean test(BillConverterEnum t) {
				return t.getType().name().equalsIgnoreCase(type);
			}
		};
	}

}
