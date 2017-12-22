/**
 * 
 */
package pl.codeprime.webservices.rest.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.codeprime.webservices.rest.controller.request.dto.ShopBasketRequestDTO;

/**
 * @author MOwsians
 *
 */
@RestController
@RequestMapping("/test")
public class TestController  extends AbstractRestHandler {
	
	
	private static Logger LOGGER = Logger.getLogger(TestController.class);
	
	
	@GetMapping
	ResponseEntity<Object> getRepositoryDetailsByUserAndRepositoryName(){
		return new ResponseEntity<>(HttpStatus.OK);
   	}
	
	@PutMapping(value = "/put")
	ResponseEntity<Map<String, Object>> putTest(@RequestBody Map<String, Object> products){

		LOGGER.info(products);
		return new ResponseEntity<Map<String, Object>>(products, HttpStatus.OK);
   	}
	
	@PutMapping(value = "/basket")
	ResponseEntity<ShopBasketRequestDTO> putTestBasket(@RequestBody ShopBasketRequestDTO basketDTO){

		LOGGER.info(basketDTO);
		return new ResponseEntity<ShopBasketRequestDTO>(basketDTO, HttpStatus.OK);
   	}

}
