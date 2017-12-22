/**
 * 
 */
package pl.codeprime.converters;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import pl.codeprime.common.functions.BoughtProductFunction;
import pl.codeprime.common.functions.ShoppingBasketFunction;
import pl.codeprime.repositories.entity.bills.shopping.BoughtProduct;
import pl.codeprime.repositories.entity.bills.shopping.Product;
import pl.codeprime.repositories.entity.bills.shopping.ShoppingBasket;
import pl.codeprime.webservices.rest.response.BoughtProductResponse;
import pl.codeprime.webservices.rest.response.ProductResponse;
import pl.codeprime.webservices.rest.response.ShoppingBasketResponse;

/**
 * @author MOwsians
 *
 */
public class ResponseConverters {

	public static ProductResponse toProductResponse(Product product) {

		ProductResponse productResponse = null;

		if (product != null && product.getDepartment() != null 
				            && StringUtils.isNotEmpty(product.getName())) {

			String department = product.getDepartment().name();
			String name = product.getName();

			productResponse = new ProductResponse(name, department);
		} else {
			productResponse = new ProductResponse("", "");
		}
		
		return productResponse;
	}
	
	public static ResponseEntity<ProductResponse> toProductResponseAsResponseEntity(Product product) {
		
		ResponseEntity<ProductResponse> entity = null;
		
		ProductResponse productResponse = toProductResponse(product);
		if(productResponse != null) {
			entity = new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
		}
		else {
			entity = new ResponseEntity<ProductResponse>(ProductResponse.createEmpty(), HttpStatus.NO_CONTENT);
		}
		
		return entity;
	}
	
	public static ShoppingBasketResponse toShoppingBasketResponse(ShoppingBasket shoppingBasket) {
		
		ShoppingBasketResponse response = new ShoppingBasketResponse();
		

		List<BoughtProductResponse> collect = shoppingBasket.getProducts()
															.stream()
																.map(BoughtProductFunction.TO_RESPONSE)
																	.collect(Collectors.toList());
		
		response.setBoughtProducts(collect);
		response.setShopName(shoppingBasket.getShopName());
		
		return response;
	}

	/**
	 * @param save
	 * @return 
	 */
	public static ResponseEntity<ShoppingBasketResponse> toShoppingBasketAsResponseEntity(ShoppingBasket save) {
		
		ShoppingBasketResponse shoppingBasketResponse = toShoppingBasketResponse(save);
		return new ResponseEntity<ShoppingBasketResponse>(shoppingBasketResponse, HttpStatus.OK);
	}

	/**
	 * @param findByDate
	 * @return 
	 */
	public static List<ShoppingBasketResponse> toShoppingBasketsResponse(List<ShoppingBasket> baskets) {
		
		
		List<ShoppingBasketResponse> basketsResponse = baskets
														.stream()
															.map(ShoppingBasketFunction.TO_RESPONSE)
																.collect(Collectors.toList());
		
		return basketsResponse;
	}
	
	
	public static ResponseEntity<List<ShoppingBasketResponse>> toResponseEntity(List<ShoppingBasket> findByDate) {
		
		ResponseEntity<List<ShoppingBasketResponse>> responseEntity = 
				new ResponseEntity<List<ShoppingBasketResponse>>(HttpStatus.NO_CONTENT);
		
		try {
			
			if(CollectionUtils.isNotEmpty(findByDate)) {
				
				List<ShoppingBasketResponse> shoppingBasketsAsResponseEntity = ResponseConverters
						.toShoppingBasketsResponse(findByDate);
				
				responseEntity = 
						new ResponseEntity<List<ShoppingBasketResponse>>(shoppingBasketsAsResponseEntity, 
																	     HttpStatus.OK);
			}
			else {
				responseEntity = 
						new ResponseEntity<List<ShoppingBasketResponse>>(HttpStatus.NOT_FOUND);
			}
			
		}catch (Exception e) {
			
			responseEntity = 
					new ResponseEntity<List<ShoppingBasketResponse>>(HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}

	/**
	 * @param save
	 * @return 
	 */
	public static BoughtProductResponse toBoughtProductResponse(BoughtProduct save) {
		
		BoughtProductResponse response = new BoughtProductResponse();
		response.setAddDate(new Date());
		response.setBoughtDate(new Date());
		response.setPrice(save.getPrice());
		response.setProductId(save.getId());
		response.setQuantity(save.getQuantity());
		response.setName(save.getName());
		
		return response;
	}

	/**
	 * @param bProductResponses
	 * @return 
	 */
	public static ResponseEntity<List<BoughtProductResponse>> 
					toBoughtProductResponse(List<BoughtProductResponse> bProductResponses) {
		
		HttpStatus status = HttpStatus.OK;
		
		if(CollectionUtils.isEmpty(bProductResponses)) {
			status = HttpStatus.NO_CONTENT;
		}
		
		ResponseEntity<List<BoughtProductResponse>> responseEntity = 
				new ResponseEntity<List<BoughtProductResponse>>(bProductResponses, status);
		
		return responseEntity;
	}
}
