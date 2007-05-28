/**
 * 
 */
package fr.lb.l5r.business.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.lb.l5r.business.entities.interfaces.IEntity;

/**
 * @author Administrateur
 *
 */
public class Entity extends AbstractEntity implements IEntity {

	//	identité
	protected int id;

	/**
	 * @see fr.lb.l5r.business.entities.Entity#getId()
	 */
	@Id	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	/**
	 * @param id set the id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
