/**
 * 
 */
package pl.codeprime.common.functions;

import java.util.Date;
import java.util.function.Function;

import pl.codeprime.repositories.entity.bills.shopping.BoughtProduct;
import pl.codeprime.repositories.entity.bills.shopping.saver.dto.BoughtProductSaverDTO;
import pl.codeprime.repositories.entity.bills.shopping.saver.dto.ProductSaverDTO;
import pl.codeprime.webservices.rest.controller.request.dto.ProductRequestDTO;
import pl.codeprime.webservices.rest.response.BoughtProductResponse;

/**
 * @author MOwsians
 *
 */
public class BoughtProductFunction {
	
	
	public static Function<BoughtProduct, BoughtProductResponse> TO_RESPONSE = 
			new Function<BoughtProduct, BoughtProductResponse>() {

					@Override
					public BoughtProductResponse apply(BoughtProduct t) {
						BoughtProductResponse response = new BoughtProductResponse();
						t.getName();
						response.setName(t.getName());
						response.setBoughtDate(new Date());
						response.setAddDate(new Date());
						response.setProductId(t.getId());
						response.setPrice(t.getPrice());
						response.setQuantity(t.getQuantity());
						
						return response;
					}
	};
	
	
	public static Function<BoughtProductSaverDTO, BoughtProduct> TO_ENTITY = 
			new Function<BoughtProductSaverDTO, BoughtProduct>() {

		@Override
		public BoughtProduct apply(BoughtProductSaverDTO t) {
			
			BoughtProduct response = new BoughtProduct();

			response.setPrice(t.getPrice());
			response.setQuantity(t.getQuantity());
			response.setName(t.getProduct().getName());

			return response;
		}
	};
	
	
	public static Function<ProductRequestDTO, BoughtProductSaverDTO> TO_SAVER_DTO = 
			new Function<ProductRequestDTO, BoughtProductSaverDTO>() {

			@Override
			public BoughtProductSaverDTO apply(ProductRequestDTO t) {
				
				BoughtProductSaverDTO dto = new BoughtProductSaverDTO();
				dto.setPrice(t.getPrice());
				dto.setQuantity(t.getQuantity());
				dto.setProduct( new ProductSaverDTO(t.getName()));
				
				return dto;
			}
	};

}
