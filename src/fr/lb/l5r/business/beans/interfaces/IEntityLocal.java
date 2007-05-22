package fr.lb.l5r.business.beans.interfaces;

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
	 * @param entityClass type de la classe m�tier
	 * @param properties liste des propri�t�s sous la forme suivante :
	 *  <nom>, <valeur>, <nom>, <valeur>
	 * @return id du nouvel objet
	 */
	int create(Class entityClass, Object... properties);
	
	/**
	 * @param properties liste des propri�t�s sous la forme suivante :
	 *  <nom>, <valeur>, <nom>, <valeur>
     * @return id du nouvel objet
	 */
	//int create(Map<String, Object> properties);

	/**
	 * @param entityClass type de la classe m�tier
	 * @param id
	 * @return trouve un objet � partir de son id
	 */
	IEntity find(Class entityClass, int id);
}
