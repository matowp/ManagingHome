/**
 * 
 */
package pl.codeprime.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.codeprime.repositories.entity.bills.shopping.Customer;

/**
 * @author MOwsians
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
