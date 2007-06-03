package fr.lb.l5r.business.beans;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.lb.l5r.business.beans.interfaces.IEntityLocal;
import fr.lb.l5r.business.entities.interfaces.IEntity;

/**
 * Comment
 * 
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @version $Revision: 37459 $
 */
@Stateless
public class EntityBean implements IEntityLocal {

	private static Logger logger = Logger.getLogger(EntityBean.class);

	@Resource
	private SessionContext context;

	@PersistenceContext(unitName = "custdb")
	private EntityManager em;

	// Système de rollback qui ne s'arrête pas à la méthode
	public IEntity create(Class entityClass, Object... properties) {

		IEntity entity = null;
		boolean rollBackNeeded = false;

		try {
			entity = (IEntity) entityClass.newInstance();
			for (int i = 0; i < properties.length; i = +2) {
				String name = (String) properties[i];
				Object value = properties[i + 1];
				try {
					Method method = entity.getClass().getMethod("set" + ((char) (name.charAt(0) - 32)) + name.substring(1), value.getClass());
					method.invoke(entity, value);
				} catch (SecurityException e) {
					logger.warn(e);
				} catch (NoSuchMethodException e) {
					logger.warn(e);
				} catch (IllegalArgumentException e) {
					logger.warn(e);
				} catch (IllegalAccessException e) {
					logger.warn(e);
				} catch (InvocationTargetException e) {
					logger.warn(e);
				}
			}
		} catch (InstantiationException e1) {
			logger.error(e1);
			rollBackNeeded = true;
		} catch (IllegalAccessException e1) {
			logger.error(e1);
			rollBackNeeded = true;
		}

		if (rollBackNeeded) {
			context.setRollbackOnly();
			return null;
		} else {
			em.persist(entity);
			return entity;
		}
	}

	@SuppressWarnings("unchecked")
	public IEntity find(Class entityClass, int id) {
		return (IEntity) em.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<IEntity> find(Class entityClass, Map<String, Object> properties) {

		boolean first = true;
		StringBuilder queryString = new StringBuilder();

		queryString.append("From ").append(entityClass.getSimpleName()).append(" as ").append(entityClass.getSimpleName().toLowerCase());

		for (String field : properties.keySet()) {
			logger.debug("create parameter '" + field + "'");
			queryString.append((first == true ? "  where " : " and ")).append(
					field.replace(entityClass.getSimpleName(), entityClass.getSimpleName().toLowerCase())).append(" like :").append(field);
			if (first == true) {
				first = false;
			}
		}

		Query query = em.createQuery(queryString.toString());
		for (String field : properties.keySet()) {
			logger.debug("get value for '" + field + "' : '" + properties.get(field) + "'");
			query.setParameter(field, properties.get(field));
			logger.debug("Search for " + queryString);
		}
		return query.getResultList();
	}
}
