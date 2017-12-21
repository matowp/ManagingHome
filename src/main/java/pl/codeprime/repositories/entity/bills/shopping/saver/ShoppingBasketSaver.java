/**
 * 
 */
package pl.codeprime.repositories.entity.bills.shopping.saver;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import pl.codeprime.common.functions.BoughtProductFunction;
import pl.codeprime.common.functions.ProductFunction;
import pl.codeprime.repositories.entity.bills.shopping.BoughtProduct;
import pl.codeprime.repositories.entity.bills.shopping.ShoppingBasket;
import pl.codeprime.repositories.entity.bills.shopping.saver.dto.ShoppingBasketSaverDTO;
import pl.codeprime.services.BoughtProductService;
import pl.codeprime.services.ProductService;
import pl.codeprime.services.ShoppingBasketService;

/**
 * @author MOwsians
 *
 */
public class ShoppingBasketSaver {

	
	public static ShoppingBasket save(ShoppingBasketSaverDTO basketSaverDTO, 
							ShoppingBasketService basketService, 
							ProductService productService, 
							BoughtProductService bProductService) {
		
		ShoppingBasketSaver shoppingBasketSaver = create(basketSaverDTO);
		ShoppingBasket savedShoppingBasket = shoppingBasketSaver.save(basketService, productService, bProductService);
		
		return savedShoppingBasket;
	}
	
	public static ShoppingBasketSaver create(ShoppingBasketSaverDTO basketSaverDTO) {
		return new ShoppingBasketSaver(basketSaverDTO);
	}

	protected ShoppingBasketSaver(ShoppingBasketSaverDTO basketSaverDTO) {
		super();
		this.basketSaverDTO = basketSaverDTO;
	}

	private ShoppingBasketSaverDTO basketSaverDTO;

	public ShoppingBasketSaverDTO getBasketSaverDTO() {
		return basketSaverDTO;
	}

	public void setBasketSaverDTO(ShoppingBasketSaverDTO basketSaverDTO) {
		this.basketSaverDTO = basketSaverDTO;
	}

	/**
	 * @param bProductService 
	 * @param productService 
	 * @param basketService 
	 * @return 
	 * 
	 */
	public ShoppingBasket save(ShoppingBasketService basketService, 
							   ProductService productService, 
							   BoughtProductService bProductService) {

		ShoppingBasket basket = new ShoppingBasket();
		basket.setBoughtDate(new Date());
		basket.setShopName(basketSaverDTO.getShopName());
		
		if(CollectionUtils.isNotEmpty(basketSaverDTO.getBoughtProducts())) {
			
			Set<BoughtProduct> boughtProducts = basketSaverDTO.getBoughtProducts()
					.stream()
						.map(BoughtProductFunction.TO_ENTITY).collect(Collectors.toSet());

			
			List<BoughtProduct> collect = boughtProducts.stream().collect(Collectors.toList());
			bProductService.save(collect);
			
			basket.setProducts(boughtProducts);
		}
		
		if(CollectionUtils.isNotEmpty(basketSaverDTO.getProducts())) {
			basketSaverDTO.getProducts().stream().filter(Objects::nonNull)
												.map(ProductFunction.TO_ENTITY)
													.forEach(productService::save);
		}
		
		ShoppingBasket savedBasket = basketService.save(basket);
		
		return savedBasket;
	}
	
}
