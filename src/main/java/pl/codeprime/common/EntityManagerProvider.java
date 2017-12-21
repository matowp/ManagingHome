/**
 * 
 */
package pl.codeprime.common;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;

/**
 * @author MOwsians
 *
 */
public class EntityManagerProvider {

	
	@SuppressWarnings("rawtypes")
	public static <T> CriteriaQuery createQuery(EntityManager entityManager, T clazz) {
		
		EntityManagerProvider create = create(entityManager);
		return create.createQuery(clazz);
	}
	
	public static CriteriaBuilder criteriaBuilder(EntityManager entityManager) {
		EntityManagerProvider create = create(entityManager);
		
		return create.getCriteriaBuilder();
	}
	
	public static EntityManagerProvider create(EntityManager entityManager) {
		return new EntityManagerProvider(entityManager);
	}
	
	private EntityManager entityManager;

	protected EntityManagerProvider(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	
	public CriteriaBuilder getCriteriaBuilder() {
		return entityManager.getCriteriaBuilder();
	}
	
	@SuppressWarnings("rawtypes")
	public <T> CriteriaQuery createQuery(T clazz) {
		
		CriteriaBuilder crBuilder = getCriteriaBuilder();
		return crBuilder.createQuery(clazz.getClass());
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> TypedQuery<T> where(T clazz, Expression<Boolean> restrictions) {
		
		CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
		CriteriaQuery<T> createQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(clazz.getClass());
		
		createQuery.where(restrictions);
		
		TypedQuery<? extends Object> typedQuery = entityManager.createQuery(createQuery);
		
		return (TypedQuery<T>) typedQuery;
	}
	
	
}
