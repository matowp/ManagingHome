/**
 * 
 */
package pl.codeprime.repositories.entity.bills.household.to;

import java.math.BigDecimal;
import java.util.Date;

import pl.codeprime.converters.ObjectConverters;
import pl.codeprime.repositories.entity.bills.household.UtilityBillType;

/**
 * @author MOwsians
 *
 */
public class UtilityBillTO {
	
	
	private String description;
	private String title;
	private Date toDate;
	private double amount;
	private UtilityBillType type;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public UtilityBillType getType() {
		return type;
	}
	public void setType(UtilityBillType type) {
		this.type = type;
	}
	
	
	public BigDecimal getAmountAsBigDecimal() {
		return ObjectConverters.toBigDecimal(getAmount());
	}

}
