/**
 * 
 */
package pl.codeprime.webservices.rest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.codeprime.converters.ObjectConverters;
import pl.codeprime.converters.ResponseConverters;
import pl.codeprime.repositories.entity.bills.shopping.ShoppingBasket;
import pl.codeprime.repositories.entity.bills.shopping.saver.ShoppingBasketSaver;
import pl.codeprime.repositories.entity.bills.shopping.saver.dto.ShoppingBasketSaverDTO;
import pl.codeprime.services.BoughtProductService;
import pl.codeprime.services.ProductService;
import pl.codeprime.services.ShoppingBasketService;
import pl.codeprime.webservices.rest.controller.request.dto.ShopBasketRequestDTO;
import pl.codeprime.webservices.rest.response.ShoppingBasketResponse;

/**
 * @author MOwsians
 *
 */
@RestController
@RequestMapping("/api/basket")
public class ShoppingBasketController extends AbstractRestHandler  {
	
	@Autowired
	ShoppingBasketService basketService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	BoughtProductService bProductService;
	
	
	@PutMapping(value = "/add", produces = "application/json")
	ResponseEntity<ShoppingBasketResponse> create(@RequestBody ShopBasketRequestDTO basketDTO) {

		ResponseEntity<ShoppingBasketResponse> response = null;

		try {

			ShoppingBasketSaverDTO shoppingBsketSaverDTO = ObjectConverters.toShoppingBsketSaverDTO(basketDTO);
			ShoppingBasket save = ShoppingBasketSaver.save(shoppingBsketSaverDTO, 
														   basketService, productService, bProductService);
			
			response = ResponseConverters.toShoppingBasketAsResponseEntity(save);

		} catch (Exception e) {
			response = new ResponseEntity<ShoppingBasketResponse>(HttpStatus.NO_CONTENT);
		}

		return response;
	}
	
	@GetMapping(value = "/find/all/{date}", produces = "application/json")
	ResponseEntity<List<ShoppingBasketResponse>> findAllBasketByDate(@RequestParam(value = "date") Date date) {

		List<ShoppingBasket> findByDate = basketService.findByDate(date);
		ResponseEntity<List<ShoppingBasketResponse>> responseEntity = 
				ResponseConverters.toResponseEntity(findByDate);

		return responseEntity;
	}
	
	@GetMapping(value = "/find/all", produces = "application/json")
	ResponseEntity<List<ShoppingBasketResponse>> findAll() {
		
		List<ShoppingBasket> findAll = basketService.findAll();
		ResponseEntity<List<ShoppingBasketResponse>> responseEntity = 
				ResponseConverters.toResponseEntity(findAll);

		return responseEntity;
	}

}
