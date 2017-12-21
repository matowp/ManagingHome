/**
 * 
 */
package pl.codeprime.repositories.entity.bills.shopping;

import org.apache.commons.lang3.EnumUtils;

/**
 * @author MOwsians
 *
 */
public enum Role {

	ADMIN,
	USER
	;
	
	
	public static Role getByName(String roleName) {
		
		Role obtainedRole = Role.USER;
		try {

			obtainedRole = EnumUtils.getEnum(Role.class, roleName);

		} catch (Exception e) {
		}

		return obtainedRole;
	}
}
