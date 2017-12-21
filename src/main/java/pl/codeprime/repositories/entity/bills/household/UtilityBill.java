/**
 * 
 */
package pl.codeprime.repositories.entity.bills.household;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MOwsians
 *
 */
@Entity
@Table(name = "utility", schema="public")
public class UtilityBill  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private UtilityBillType type;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="receipt")
	private String receipt;
	
	@Column(name="pay_date")
	private Date payDate;
	
	@Column(name="to_date")
	private Date toDate;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;

	public UtilityBillType getType() {
		return type;
	}

	public void setType(UtilityBillType type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
