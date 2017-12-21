/**
 * 
 */
package pl.codeprime.webservices.rest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.codeprime.common.functions.ProductFunction;
import pl.codeprime.converters.ObjectConverters;
import pl.codeprime.converters.ResponseConverters;
import pl.codeprime.filters.ProductFilter;
import pl.codeprime.repositories.entity.bills.shopping.Department;
import pl.codeprime.repositories.entity.bills.shopping.Product;
import pl.codeprime.services.ProductService;
import pl.codeprime.webservices.rest.response.ProductResponse;
import pl.codeprime.webservices.rest.response.ResponseEnum;

/**
 * @author MOwsians
 *
 */
@RestController
@RequestMapping("/api/product")
public class ProductController extends AbstractRestHandler {

	@Autowired
	ProductService productService;
	
	@RequestMapping(
			method = RequestMethod.PUT, 
			value = "/add/{name}", 
			produces = "application/json" )
	ResponseEntity<ProductResponse> add(@PathVariable String name) {

		ResponseEntity<ProductResponse> response = null;

		try {

			response = save(name, Department.OTHER.name());

		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		}

		return response;
	}
	
	@RequestMapping(
			method = RequestMethod.PUT, 
			value = "/add/{name}/{department}", 
			produces = "application/json" )
	ResponseEntity<ProductResponse> add(@PathVariable String name, @PathVariable String department) {

		ResponseEntity<ProductResponse> response = null;
		
		try {
			response = save(name, department);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		}
		
		return response;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/find/all")
	Response findAll(){
		
		Response response = null;
		
		try {
			
			List<Product> products  = productService.findAll();
			response = ResponseEnum.OK.entity(products);
			
		}catch (Exception e) {
			response = ResponseEnum.BAD_REQUEST.buildResponse();
		}
		
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET,
					value = "/find/name/{productName}")
	ResponseEntity<List<ProductResponse>> findByName(@PathVariable String productName){
		
		ResponseEntity<List<ProductResponse>> response = null;
		
		List<Product> findByName = productService.findByName(productName);
		
		if(CollectionUtils.isNotEmpty(findByName)){
					
			List<ProductResponse> collect = (List<ProductResponse>) findByName.stream()
					.map(ProductFunction.TO_RESPONSE)
					.collect(Collectors.toList());
			
			response = new ResponseEntity<List<ProductResponse>>(collect, HttpStatus.OK);
		}
		else
		{
			response = new ResponseEntity<List<ProductResponse>>(Arrays.asList(), HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	
	private ResponseEntity<ProductResponse> save(String name, String department) {
		
		ResponseEntity<ProductResponse> convertedResponse = null;
		
		Product product = ObjectConverters.toProduct(name, department);
		Product savedProduct = null;
		List<Product> findByName = productService.findByName(name);
		
		if(CollectionUtils.isEmpty(findByName)){
			savedProduct =  productService.save(product);
		}
		else 
		{
			Optional<Product> foundProduct = findByName
												.stream()
													.filter(ProductFilter.NAME_AND_DEPARTMENT(product))
													.findAny();
			
			savedProduct = foundProduct.get();
		}
		
		convertedResponse = ResponseConverters.toProductResponseAsResponseEntity(savedProduct);
		
		return convertedResponse;
	}
	
}
