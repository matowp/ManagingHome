/**
 * 
 */
package pl.codeprime.webservices.rest.controller;

import java.util.ArrayList;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.codeprime.converters.ObjectConverters;
import pl.codeprime.repositories.BoughtProductRepository;
import pl.codeprime.repositories.entity.bills.shopping.BoughtProduct;
import pl.codeprime.repositories.entity.bills.shopping.Product;
import pl.codeprime.repositories.entity.bills.shopping.ShoppingBasket;
import pl.codeprime.services.ShoppingBasketService;
import pl.codeprime.webservices.rest.response.ResponseEnum;

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
	Response add(@PathVariable String name, @PathVariable String basketId) {

		Product product = new Product();
		product.setName(name);
		
		ShoppingBasket findById = shoppingBasketService.findById(Long.parseLong(basketId));
		BoughtProduct boughtProduct = ObjectConverters
										.toBoughtProduct(product, findById.getBoughtDate(), "shopName");
		BoughtProduct save = boughtRepository.save(boughtProduct);
		
		return ResponseEnum.OK.entity(save);
	}
	
	@GetMapping(value="/find/all")
	Response findAll(){
		
		ArrayList<BoughtProduct> newArrayList = new ArrayList<>();
		Iterable<BoughtProduct> findAll = boughtRepository.findAll();
		findAll.forEach(newArrayList::add);
		
		return ResponseEnum.OK.entity(newArrayList);
	}
	
	@GetMapping(value = "/find/name/{productName}")
	Response findByUsername(@PathVariable String productName){
		return Response.status(Status.OK).build();
	}
	
}
