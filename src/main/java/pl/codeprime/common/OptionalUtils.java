/**
 * 
 */
package pl.codeprime.common;

import java.util.Optional;

/**
 * @author MOwsians
 *
 */
public class OptionalUtils {
	
	
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(Optional optional) {
		return optional != null && optional.isPresent();
	}

}
