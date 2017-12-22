/**
 * 
 */
package pl.codeprime.converters;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import pl.codeprime.common.functions.BoughtProductFunction;
import pl.codeprime.common.functions.ProductFunction;
import pl.codeprime.repositories.entity.bills.shopping.BoughtProduct;
import pl.codeprime.repositories.entity.bills.shopping.Department;
import pl.codeprime.repositories.entity.bills.shopping.Product;
import pl.codeprime.repositories.entity.bills.shopping.ShoppingBasket;
import pl.codeprime.repositories.entity.bills.shopping.saver.dto.BoughtProductSaverDTO;
import pl.codeprime.repositories.entity.bills.shopping.saver.dto.ProductSaverDTO;
import pl.codeprime.repositories.entity.bills.shopping.saver.dto.ShoppingBasketSaverDTO;
import pl.codeprime.webservices.rest.controller.request.dto.ShopBasketRequestDTO;
import pl.codeprime.webservices.rest.to.ProductTO;

/**
 * @author MOwsians
 *
 */
public class ObjectConverters {
	
	public static BoughtProduct toBoughtProduct(Product product, String boughtDate, String shopName) {
		
		BoughtProduct prod = new BoughtProduct();
		
		return prod;
	}
	
	public static BoughtProduct toBoughtProduct(Product product, Date boughtDate, String  shopName) {
		
		BoughtProduct prod = new BoughtProduct();
		
		return prod;
	}
	
	
	
	public static Product toProduct(String productName) {
		Product prod = toProduct(productName, Department.OTHER.name());
		
		return prod;
	}

	public static Product toProduct(String productName, String departmentAsString) {
		
		Product prod = new Product();
		
		Department department = Department.byString(departmentAsString);
		prod.setDepartment(department);
		prod.setName(productName);
		
		return prod;
	}
	
	
	public static Date dateNow() {
		return new Date();
	}
	
	public static LocalDateTime LocalDateTimeNow() {
		return LocalDateTime.now();
	}
	
	public Date toDate(LocalDateTime localDateTime) {
		return toDate(localDateTime, ZoneId.systemDefault());
	}
	
	public Date toDate(LocalDateTime localDateTime, ZoneId zoneId) {
		return Date.from(localDateTime.atZone(zoneId).toInstant());
	}

	/**
	 * @param shop
	 * @param products
	 * @param boughtDate
	 * @return 
	 */
	public static ShoppingBasket toShoppingBasket(String shopName, Set<BoughtProduct> products, Date boughtDate) {
		
		ShoppingBasket basket = new ShoppingBasket();
		
		if(boughtDate == null){
			boughtDate = dateNow();
		}
		
		basket.setBoughtDate(boughtDate);
		basket.setProducts(products);
		
		return basket;
	}

	/**
	 * @param productTO
	 * @return
	 */
	public static Product toProduct(ProductTO productTO) {
		return toProduct(productTO.getName(), productTO.getDepartment());
	}
	
	public static BigDecimal toBigDecimal(Object value) {
		
		BigDecimal converted = null;
		if(Double.class.isAssignableFrom(value.getClass())) {
			converted = new BigDecimal((Double) value);
		}
		
		return converted;
	}
	
	public static void toLocalDate(String dateAsString) {
	}

	/**
	 * @param basketDTO
	 * @return 
	 */
	public static ShoppingBasketSaverDTO toShoppingBsketSaverDTO(ShopBasketRequestDTO basketDTO) {
		
		ShoppingBasketSaverDTO shoppingBasketSaverDTO = new ShoppingBasketSaverDTO();
		
		shoppingBasketSaverDTO.setShopName(basketDTO.getShopName());
		
		List<ProductSaverDTO> productSaverDTOs = basketDTO.getProducts()
															.stream()
																.map(ProductFunction.TO_SAVER)
																	.collect(Collectors.toList());
		
		shoppingBasketSaverDTO.setProducts(productSaverDTOs);
		
		List<BoughtProductSaverDTO> boughtProductSaverDTOs = basketDTO.getProducts()
																		.stream()
																			.map(BoughtProductFunction.TO_SAVER_DTO)
																				.collect(Collectors.toList());
		shoppingBasketSaverDTO.setBoughtProducts(boughtProductSaverDTOs);
		
		return shoppingBasketSaverDTO;
	}

}
