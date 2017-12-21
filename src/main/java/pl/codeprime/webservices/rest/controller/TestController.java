/**
 * 
 */
package pl.codeprime.webservices.rest.controller;

import java.util.Map;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.codeprime.webservices.rest.controller.request.ShopBasketRequestDTO;
import pl.codeprime.webservices.rest.response.ResponseEnum;

/**
 * @author MOwsians
 *
 */
@RestController
@RequestMapping("/test")
public class TestController  extends AbstractRestHandler {
	
	
	private static Logger LOGGER = Logger.getLogger(TestController.class);
	
	
	@GetMapping
	Response getRepositoryDetailsByUserAndRepositoryName(){
		return ResponseEnum.OK.buildResponse();
   	}
	
	@PutMapping(value = "/put")
	Response putTest(@RequestBody Map<String, Object> products){

		LOGGER.info(products);
		
		return ResponseEnum.OK.buildResponse();
   	}
	
	@PutMapping(value = "/basket")
	Response putTestBasket(@RequestBody ShopBasketRequestDTO basketDTO){

		LOGGER.info(basketDTO);
		
		return ResponseEnum.OK.buildResponse();
   	}

}
