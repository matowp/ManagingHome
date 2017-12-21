/**
 * 
 */
package pl.codeprime.converters;

import java.util.Date;
import java.util.List;

import pl.codeprime.common.BILL;
import pl.codeprime.repositories.entity.bills.household.UtilityBill;
import pl.codeprime.repositories.entity.bills.household.to.UtilityBillTO;
import pl.codeprime.webservices.rest.response.HouseholdBillResponse;

/**
 * @author MOwsians
 *
 */
public class BillConverter {
	
	
	public static UtilityBillTO toGasBillTO(double amount, Date toDate, String title, String description) {
		return BillConverterEnum.GAS.toBillTO(amount, toDate, title, description);
	}
	
	public static UtilityBillTO toWaterBillTO(double amount, Date toDate, String title, String description) {
		return BillConverterEnum.WATER.toBillTO(amount, toDate, title, description);
	}
	
	public static UtilityBillTO toAdminBillTO(double amount, Date toDate, String title, String description) {
		return BillConverterEnum.ADMINISTATION.toBillTO(amount, toDate, title, description);
	}
	
	public static UtilityBillTO toNetBillTO(double amount, Date toDate, String title, String description) {
		return BillConverterEnum.NET.toBillTO(amount, toDate, title, description);
	}
	
	public static UtilityBillTO toTelBillTO(double amount, Date toDate, String title, String description) {
		return BillConverterEnum.TEL.toBillTO(amount, toDate, title, description);
	}
	
	public static UtilityBillTO toElectrityBillTO(double amount, Date toDate, String title, String description) {
		return BillConverterEnum.ELECTRICITY.toBillTO(amount, toDate, title, description);
	}
	
	public static UtilityBill toEntity(UtilityBillTO billTO) {
		
		UtilityBill utilityBill = new UtilityBill();
		
		utilityBill.setAmount(billTO.getAmountAsBigDecimal());
		utilityBill.setTitle(billTO.getTitle());
		utilityBill.setDescription(billTO.getDescription());
		utilityBill.setPayDate(new Date());
		utilityBill.setToDate(billTO.getToDate());
		utilityBill.setType(billTO.getType());
		
		String receipt = null;
		
		switch (billTO.getType()) {
		case ADMINISTATION:
			receipt = BILL.RECEIPT.ADMIN;
			break;
		case ELECTRICITY:
			receipt = BILL.RECEIPT.ELECTRICITY;
			break;
		case GAS:
			receipt = BILL.RECEIPT.GAS;
			break;
		case MEDIA_NET:
			receipt = BILL.RECEIPT.NET;
			break;
		case MEDIA_TEL:
			receipt = BILL.RECEIPT.TEL;
			break;
		case OTHER:
			receipt = BILL.RECEIPT.OTHER;
			break;
		case WATER:
			receipt = BILL.RECEIPT.WATER;
			break;
		default:
			break;
		}
		
		utilityBill.setReceipt(receipt);
		
		return utilityBill;
	}
	
	public static HouseholdBillResponse toResponse(UtilityBill bill) {
		
		HouseholdBillResponse response = null;
		if(bill != null) {
			response = new HouseholdBillResponse();
			response.setAmount(bill.getAmount().toEngineeringString());
			response.setTitle(bill.getTitle());
			response.setDescription(bill.getDescription());
			response.setReceipt(bill.getReceipt());
			response.setToDatePay(bill.getToDate().toString());
			response.setType(bill.getType().name());
		}
		
		return response;
	}
	
	public static HouseholdBillResponse toResponse(List<UtilityBill> bills) {
		
		return null;
	}

}
