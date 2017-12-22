/**
 * 
 */
package pl.codeprime.services.queries;

/**
 * @author MOwsians
 *
 */
public class BoughProductQuery {
	
	public static final String WITH_SHOP_NAME = "";
	
	
	
	public static void withShopName() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ").append("bp.name as name").append(",")
		.append(" bp.id as id, ").append("bp.quantity as quantity")
		.append(",").append("bp.price as price ").append(" , ")
		.append(" s.shopName as shopName")
		.append(" s.boughtDate as buyDate")
		.append(" join ShoppingBasket s  on ").append(" s.boughtProducts.con ");
		
	}

}
