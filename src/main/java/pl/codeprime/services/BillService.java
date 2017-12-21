/**
 * 
 */
package pl.codeprime.services;

import java.util.List;

import pl.codeprime.repositories.entity.bills.household.UtilityBill;
import pl.codeprime.repositories.entity.bills.household.to.UtilityBillTO;

/**
 * @author MOwsians
 *
 */
public interface BillService {

	/**
	 * @param billTO
	 */
	UtilityBill save(UtilityBillTO billTO);
	List<UtilityBill> findAll();

}
