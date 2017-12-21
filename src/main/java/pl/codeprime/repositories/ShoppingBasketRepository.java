/**
 * 
 */
package pl.codeprime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.codeprime.repositories.entity.bills.shopping.ShoppingBasket;

/**
 * @author MOwsians
 *
 */
@Repository("shoppings")
public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Long> {
}
