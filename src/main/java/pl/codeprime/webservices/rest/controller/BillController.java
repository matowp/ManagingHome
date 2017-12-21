/**
 * 
 */
package pl.codeprime.webservices.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.codeprime.converters.BillConverter;
import pl.codeprime.converters.BillConverterEnum;
import pl.codeprime.functions.BillFunction;
import pl.codeprime.repositories.entity.bills.household.UtilityBill;
import pl.codeprime.repositories.entity.bills.household.to.UtilityBillTO;
import pl.codeprime.services.BillService;
import pl.codeprime.webservices.rest.response.HouseholdBillResponse;

/**
 * @author MOwsians
 *
 */
@RestController
@RequestMapping("/api/bill")
public class BillController extends AbstractRestHandler {

	@Autowired
	BillService billService;
	
	@PutMapping(
				value = "/add", 
				produces = MediaType.APPLICATION_JSON)
	ResponseEntity<HouseholdBillResponse> add(@RequestParam("type") String type, 
				 			  @RequestParam("amount") String amount, 
				 			  @RequestParam("title") String title, 
				 			  @RequestParam("to") String toDate,
				 			  @RequestParam("descr") String description) {
		
		UtilityBillTO billTO = BillConverterEnum.byType(type).toBillTO(amount, toDate, title, description);
		UtilityBill bill = billService.save(billTO);
		
		HouseholdBillResponse response = BillConverter.toResponse(bill);
		ResponseEntity<HouseholdBillResponse> responseEntity = getResponseEntity(response);
		
		return responseEntity;
	}
	
	
	
	@PutMapping(value = "/add/gas", produces = MediaType.APPLICATION_JSON)
	ResponseEntity<HouseholdBillResponse> addGas(@RequestParam("amount") String amount, 
								 @RequestParam("title") String title,
								 @RequestParam("to") String toDate, 
								 @RequestParam("descr") String description) {

		UtilityBillTO billTO = BillConverterEnum.GAS.toBillTO(amount, toDate, title, description);
		UtilityBill bill = billService.save(billTO);

		HouseholdBillResponse response = BillConverter.toResponse(bill);
		ResponseEntity<HouseholdBillResponse> responseEntity = getResponseEntity(response);

		return responseEntity;
	}
	
	@PutMapping(value = "/add/water", produces = MediaType.APPLICATION_JSON)
	ResponseEntity<HouseholdBillResponse> addWater(@RequestParam("amount") String amount, 
								   @RequestParam("title") String title,
								   @RequestParam("to") String toDate, 
								   @RequestParam("descr") String description) {

		UtilityBillTO billTO = BillConverterEnum.WATER.toBillTO(amount, toDate, title, description);
		UtilityBill bill = billService.save(billTO);

		HouseholdBillResponse response = BillConverter.toResponse(bill);
		ResponseEntity<HouseholdBillResponse> responseEntity = getResponseEntity(response);

		return responseEntity;
	}
	
	@PutMapping(value = "/add/tel", produces = MediaType.APPLICATION_JSON)
	ResponseEntity<HouseholdBillResponse> addTel(@RequestParam("amount") String amount, 
								 @RequestParam("title") String title,
								 @RequestParam("to") String toDate, 
								 @RequestParam("descr") String description) {

		UtilityBillTO billTO = BillConverterEnum.TEL.toBillTO(amount, toDate, title, description);
		UtilityBill bill = billService.save(billTO);

		HouseholdBillResponse response = BillConverter.toResponse(bill);
		ResponseEntity<HouseholdBillResponse> responseEntity = getResponseEntity(response);

		return responseEntity;
	}
	
	@PutMapping(value = "/add/net", produces = MediaType.APPLICATION_JSON)
	ResponseEntity<HouseholdBillResponse> addNet(@RequestParam("amount") String amount, 
								 @RequestParam("title") String title,
								 @RequestParam("to") String toDate, 
								 @RequestParam("descr") String description) {

		UtilityBillTO billTO = BillConverterEnum.NET.toBillTO(amount, toDate, title, description);
		UtilityBill bill = billService.save(billTO);

		HouseholdBillResponse response = BillConverter.toResponse(bill);
		ResponseEntity<HouseholdBillResponse> responseEntity = getResponseEntity(response);

		return responseEntity;
	}
	
	@PutMapping(value = "/add/admin", produces = MediaType.APPLICATION_JSON)
	ResponseEntity<HouseholdBillResponse> addAdmin(@RequestParam("amount") String amount, 
								 @RequestParam("title") String title,
								 @RequestParam("to") String toDate, 
								 @RequestParam("descr") String description) {

		UtilityBillTO billTO = BillConverterEnum.ADMINISTATION.toBillTO(amount, toDate, title, description);
		UtilityBill bill = billService.save(billTO);

		HouseholdBillResponse response = BillConverter.toResponse(bill);
		ResponseEntity<HouseholdBillResponse> responseEntity = getResponseEntity(response);

		return responseEntity;
	}
	
	@PutMapping(value = "/add/power", produces = MediaType.APPLICATION_JSON)
	ResponseEntity<HouseholdBillResponse> addElectricity(@RequestParam("amount") String amount, 
								 @RequestParam("title") String title,
								 @RequestParam("to") String toDate, 
								 @RequestParam("descr") String description) {

		UtilityBillTO billTO = BillConverterEnum.ELECTRICITY.toBillTO(amount, toDate, title, description);
		UtilityBill bill = billService.save(billTO);

		HouseholdBillResponse response = BillConverter.toResponse(bill);
		ResponseEntity<HouseholdBillResponse> responseEntity = getResponseEntity(response);

		return responseEntity;
	}
	
	@GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON)
	ResponseEntity<List<HouseholdBillResponse>> get() {
		
		List<UtilityBill> findAll = billService.findAll();
		List<HouseholdBillResponse> collect = findAll.stream()
														.map(BillFunction.BILL_TO_RESPONSE)
															.collect(Collectors.toList());
		
		ResponseEntity<List<HouseholdBillResponse>> responseEntity = 
					new ResponseEntity<List<HouseholdBillResponse>>(collect, HttpStatus.OK);
		
		if(CollectionUtils.isEmpty(collect)){
			responseEntity = new ResponseEntity<List<HouseholdBillResponse>>(collect, HttpStatus.NO_CONTENT);
		}
		
		return responseEntity;
	}
	
	private ResponseEntity<HouseholdBillResponse> getResponseEntity(HouseholdBillResponse response){
		
		
		ResponseEntity<HouseholdBillResponse> responseEntity = null;
		if(response == null) {
			responseEntity = new ResponseEntity<HouseholdBillResponse>(new HouseholdBillResponse(),
																	   HttpStatus.BAD_REQUEST); 
		}
		else {
			responseEntity = new ResponseEntity<HouseholdBillResponse>(response, HttpStatus.OK);
		}

		return responseEntity;
	}
	
}
