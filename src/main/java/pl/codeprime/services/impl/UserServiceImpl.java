/**
 * 
 */
package pl.codeprime.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.codeprime.repositories.UserCustomRepository;
import pl.codeprime.repositories.UserRepository;
import pl.codeprime.repositories.entity.bills.shopping.User;
import pl.codeprime.services.UserService;

/**
 * @author MOwsians
 *
 */
@Service("userrService")
public class UserServiceImpl implements UserService, UserCustomRepository{

	@Autowired
	UserRepository userRepository;
	
	@PersistenceContext
    EntityManager entityManager;

	/* (non-Javadoc)
	 * @see pl.codeprime.repositories.UserCustomRepository#findByUsername(java.lang.String)
	 */
	@Override
	public List<User> findByUsername(String username) {
		
		CriteriaBuilder crBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> createQuery = crBuilder.createQuery(User.class);
		
		Root<User> from = createQuery.from(User.class);
		createQuery.where(crBuilder.equal(from.get("username"), username));
		
		TypedQuery<User> query = entityManager.createQuery(createQuery);
		List<User> resultList = query.getResultList();
		
		return resultList;
	}
}
