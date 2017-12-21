/**
 * 
 */
package pl.codeprime.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.codeprime.converters.BillConverter;
import pl.codeprime.repositories.BillRepository;
import pl.codeprime.repositories.entity.bills.household.UtilityBill;
import pl.codeprime.repositories.entity.bills.household.to.UtilityBillTO;
import pl.codeprime.services.BillService;

/**
 * @author MOwsians
 *
 */
@Service("billService")
public class BillServiceImpl implements BillService {

	@Autowired
	BillRepository billRepository;
	
	@PersistenceContext
	EntityManager entityManager;

	/* (non-Javadoc)
	 * @see pl.codeprime.services.BillService#save(pl.codeprime.repositories.entity.bills.household.to.UtilityBillTO)
	 */
	@Override
	public UtilityBill save(UtilityBillTO billTO) {
		
		UtilityBill bill = BillConverter.toEntity(billTO);
		UtilityBill save = billRepository.save(bill);
		
		return save;
	}

	/* (non-Javadoc)
	 * @see pl.codeprime.services.BillService#findAll()
	 */
	@Override
	public List<UtilityBill> findAll() {
		return billRepository.findAll();
	}
	
}
