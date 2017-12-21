/**
 * 
 */
package pl.codeprime.common.functions;

import java.util.function.Function;

import pl.codeprime.converters.ResponseConverters;
import pl.codeprime.repositories.entity.bills.shopping.Department;
import pl.codeprime.repositories.entity.bills.shopping.Product;
import pl.codeprime.repositories.entity.bills.shopping.saver.dto.ProductSaverDTO;
import pl.codeprime.webservices.rest.controller.request.dto.ProductRequestDTO;
import pl.codeprime.webservices.rest.response.ProductResponse;

/**
 * @author MOwsians
 *
 */
public class ProductFunction {

	public static Function<Product, ProductResponse> TO_RESPONSE = new Function<Product, ProductResponse>() {

		@Override
		public ProductResponse apply(Product t) {
			return ResponseConverters.toProductResponse(t);
		}
	};
	
	public static Function<ProductSaverDTO, Product> TO_ENTITY = new Function<ProductSaverDTO, Product>() {

		@Override
		public Product apply(ProductSaverDTO t) {
			
			Product product = new Product();
			product.setName(t.getName());
			product.setDepartment(Department.OTHER);
			
			return product;
		}
	};
	
	public static Function<ProductRequestDTO, ProductSaverDTO> TO_SAVER = new Function<ProductRequestDTO, ProductSaverDTO>() {

		@Override
		public ProductSaverDTO apply(ProductRequestDTO t) {
			return new ProductSaverDTO(t.getName());
		}
	};
}
