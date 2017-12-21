/**
 * 
 */
package pl.codeprime.converters;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import pl.codeprime.common.SysDate;
import pl.codeprime.filters.BillFilter;
import pl.codeprime.repositories.entity.bills.household.UtilityBillType;
import pl.codeprime.repositories.entity.bills.household.to.UtilityBillTO;

/**
 * @author MOwsians
 *
 */
public enum BillConverterEnum {
	
	GAS(UtilityBillType.GAS),
	WATER(UtilityBillType.WATER),
	ELECTRICITY(UtilityBillType.ELECTRICITY),
	NET(UtilityBillType.MEDIA_NET),
	TEL(UtilityBillType.MEDIA_TEL),
	ADMINISTATION(UtilityBillType.ADMINISTATION),
	UKNOW(UtilityBillType.OTHER)
	;

	private UtilityBillType type;

	private BillConverterEnum(UtilityBillType type) {
		this.type = type;
	}
	
	public UtilityBillTO toBillTO(double amount, Date toDate, 
								  String title, String description) {
		
		UtilityBillTO bill = new UtilityBillTO();
		bill.setType(getType());
		bill.setAmount(amount);
		bill.setToDate(toDate);
		bill.setTitle(title);
		bill.setDescription(description);
		
		return bill;
	}

	public UtilityBillType getType() {
		return type;
	}
	
	public static BillConverterEnum byType(String type) {
		
		List<BillConverterEnum> asList = Arrays.asList(BillConverterEnum.values());
		
		BillConverterEnum billConverterENum = asList.stream()
														.filter(BillFilter.TYPE_NAME(type))
															.findAny().orElse(UKNOW);
		
		return billConverterENum;
		
	}

	/**
	 * @param amount
	 * @param toDate
	 * @param title
	 * @param description
	 * @return 
	 */
	public UtilityBillTO toBillTO(String amount, String toDate, String title, String description) {
		
		Date to = SysDate.create(toDate).getDate();
		return toBillTO(Double.parseDouble(amount), to, title, description);
	}
	
}
