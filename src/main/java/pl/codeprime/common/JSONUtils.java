/**
 * 
 */
package pl.codeprime.common;

import com.google.gson.Gson;

/**
 * @author MOwsians
 *
 */
public class JSONUtils {
	
	
	public static Gson gson = new Gson();
	
	public static <T> Object toObject(String json, T value) {
		 return gson.fromJson(json, value.getClass());
	}

}
