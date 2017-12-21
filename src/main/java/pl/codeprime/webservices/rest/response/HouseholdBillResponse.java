/**
 * 
 */
package pl.codeprime.webservices.rest.response;

/**
 * @author MOwsians
 *
 */
public class HouseholdBillResponse {

	private String receipt;
	private String description;
	private String amount;
	private String title;
	private String toDatePay;
	private String type;
	
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getToDatePay() {
		return toDatePay;
	}
	public void setToDatePay(String toDatePay) {
		this.toDatePay = toDatePay;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
