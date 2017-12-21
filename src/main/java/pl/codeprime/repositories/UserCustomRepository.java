/**
 * 
 */
package pl.codeprime.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pl.codeprime.repositories.entity.bills.shopping.User;

/**
 * @author MOwsians
 *
 */
public interface UserCustomRepository {
	
	 @Query("select u from User u where u.username = :username")
	List<User> findByUsername(String username);

}
