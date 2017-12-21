/**
 * 
 */
package pl.codeprime.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.codeprime.repositories.entity.bills.shopping.User;

/**
 * @author MOwsians
 *
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends CrudRepository<User, Long> {

}
