/**
 * 
 */
package pl.codeprime.repositories.entity.bills.shopping;

import java.util.Arrays;

/**
 * @author MOwsians
 *
 */
public enum Department {
	
	FOOD,
	CHEMICAL,
	OTHER,
	DAIRY,
	BAKER,
	;

	
	public static Department byString(String deparment) {
		
		Department obtainedENum = Arrays.asList(Department.values()).stream()
											.filter(d -> d.name()
												.equalsIgnoreCase(deparment))
													.findFirst()
														.orElse(OTHER);
		
		return obtainedENum;
	}

}
