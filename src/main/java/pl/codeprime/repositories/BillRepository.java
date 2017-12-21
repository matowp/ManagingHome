/**
 * 
 */
package pl.codeprime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.codeprime.repositories.entity.bills.household.UtilityBill;

/**
 * @author MOwsians
 *
 */
@RepositoryRestResource(collectionResourceRel = "bill", path = "bill")
public interface BillRepository extends JpaRepository<UtilityBill,Long> {
}
