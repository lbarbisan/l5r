package fr.lb.l5r.business.beans.interfaces;

import java.util.Collection;
import java.util.Map;

import javax.ejb.Local;

import fr.lb.l5r.business.entities.interfaces.IEntity;


/**
 * Comment
 * 
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @version $Revision: 37459 $
 */
@Local
public interface IEntityLocal {
	
	/**
	 * @param entityClass type de la classe métier
	 * @param properties liste des propriétés sous la forme suivante :
	 *  <nom>, <valeur>, <nom>, <valeur>
	 * @return nouvel objet
	 */
	IEntity create(Class entityClass, Object... properties);

	/**
	 * @param entityClass type de la classe métier
	 * @param id
	 * @return trouve un objet à partir de son id
	 */
	IEntity find(Class entityClass, int id);
	
	/**
	 * @param entityClass type de la classe métier
	 * @param properties liste des propriétés sous la forme suivante :
	 *  <nom>, <valeur>, <nom>, <valeur>
	 * @return retourne la liste des objet qui correspondent au critère
	 */
	Collection<IEntity> find(Class entityClass, Map<String, Object> properties);
	
	/**
	 * 
	 * @param entity
	 */
	public void save(IEntity entity);
}