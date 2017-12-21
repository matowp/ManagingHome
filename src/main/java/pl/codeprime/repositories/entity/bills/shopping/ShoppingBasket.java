/**
 * 
 */
package pl.codeprime.repositories.entity.bills.shopping;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author MOwsians
 *
 */
@Entity
@Table(name = "shopping_basket", schema="public")
public class ShoppingBasket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sb_product", 
	joinColumns = @JoinColumn(name = "sb_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	private Set<BoughtProduct> boughtProducts;
	
	private String shopName;
	
	@Column
	private Date boughtDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<BoughtProduct> getProducts() {
		return boughtProducts;
	}

	public void setProducts(Set<BoughtProduct> boughtProducts) {
		this.boughtProducts = boughtProducts;
	}

	public Date getBoughtDate() {
		return boughtDate;
	}

	public void setBoughtDate(Date boughtDate) {
		this.boughtDate = boughtDate;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	

}
