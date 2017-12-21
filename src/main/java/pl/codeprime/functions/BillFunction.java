/**
 * 
 */
package pl.codeprime.functions;

import java.util.function.Function;

import pl.codeprime.converters.BillConverter;
import pl.codeprime.repositories.entity.bills.household.UtilityBill;
import pl.codeprime.webservices.rest.response.HouseholdBillResponse;

/**
 * @author MOwsians
 *
 */
public class BillFunction {
	
	public static Function<UtilityBill, HouseholdBillResponse> BILL_TO_RESPONSE = new Function<UtilityBill, HouseholdBillResponse>() {

		@Override
		public HouseholdBillResponse apply(UtilityBill t) {
			HouseholdBillResponse response = BillConverter.toResponse(t);
			return response;
		}
	};

}
