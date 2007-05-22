/**
 * 
 */
package fr.lb.l5r.business.entities;

import javax.persistence.Transient;

import fr.lb.l5r.business.entities.interfaces.IEntity;

/**
 * Classe peremttant de stock� les comp�tences.
 * @author lbarbisan
 *
 */
public class Skill extends Entity implements IEntity {

	/**
	 * 
	 */
	@Transient	private static final long serialVersionUID = -7524146796053335073L;

	//Nom de la comp�tence
	private String name;
	//Description de la comp�tence
	private String description;
	//Type de comp�tence: valorisante/D�vlorisante/Bugei/Marchand
	private String type;
	//CDC:3,Anneaux sur lequelle s'applique la comp�tance, peut �tre 'variable'
	private String ring;

}
