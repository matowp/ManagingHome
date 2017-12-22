/**
 * 
 */
package pl.codeprime.webservices.rest.controller;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.codeprime.converters.ObjectConverters;
import pl.codeprime.converters.ResponseConverters;
import pl.codeprime.repositories.BoughtProductRepository;
import pl.codeprime.repositories.entity.bills.shopping.BoughtProduct;
import pl.codeprime.repositories.entity.bills.shopping.Product;
import pl.codeprime.repositories.entity.bills.shopping.ShoppingBasket;
import pl.codeprime.services.ShoppingBasketService;
import pl.codeprime.webservices.rest.response.BoughtProductResponse;

/**
 * @author MOwsians
 *
 */
@RestController
@RequestMapping("/api/bought")
public class BoughtProductController  extends AbstractRestHandler {

	@Autowired
	BoughtProductRepository boughtRepository;
	
	@Autowired
	ShoppingBasketService shoppingBasketService;
	
	@PutMapping(
			value = "/add/{name}", 
			produces = "application/json" )
	ResponseEntity<BoughtProductResponse> add(@PathVariable String name, @PathVariable String basketId) {

		Product product = new Product();
		product.setName(name);
		
		ShoppingBasket findById = shoppingBasketService.findById(Long.parseLong(basketId));
		BoughtProduct boughtProduct = ObjectConverters
										.toBoughtProduct(product, findById.getBoughtDate(), "shopName");
		BoughtProduct save = boughtRepository.save(boughtProduct);
		
		BoughtProductResponse boughtProductResponse = ResponseConverters.toBoughtProductResponse(save);
		ResponseEntity<BoughtProductResponse> responseEntity = 
									new ResponseEntity<BoughtProductResponse>(boughtProductResponse, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@GetMapping(value="/find/all")
	ResponseEntity<List<BoughtProductResponse>> findAll(){
		
		List<BoughtProductResponse> bProductResponses = Lists.newArrayList();
		boughtRepository.findAll()
							.forEach(b ->bProductResponses.add(ResponseConverters.toBoughtProductResponse(b)));
		
		ResponseEntity<List<BoughtProductResponse>> boughtProductResponse = ResponseConverters
														.toBoughtProductResponse(bProductResponses);
		return boughtProductResponse;
	}
	
	@GetMapping(value = "/find/name/{productName}")
	Response findByUsername(@PathVariable String productName){
		return Response.status(Status.OK).build();
	}
	
}
