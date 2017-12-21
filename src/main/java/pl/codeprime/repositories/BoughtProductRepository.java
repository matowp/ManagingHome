/**
 * 
 */
package pl.codeprime.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.codeprime.repositories.entity.bills.shopping.BoughtProduct;

/**
 * @author MOwsians
 *
 */
@RepositoryRestResource(collectionResourceRel = "boughtproducts", path = "boughtproducts")
public interface BoughtProductRepository extends CrudRepository<BoughtProduct,Long> {

}
