/**
 * 
 */
package fr.lb.l5r.business.entities;

import javax.persistence.Transient;

import fr.lb.l5r.business.entities.interfaces.IEntity;

/**
 * Classe peremttant de stocké les compétences.
 * @author lbarbisan
 *
 */
public class Skill extends Entity implements IEntity {

	/**
	 * 
	 */
	@Transient	private static final long serialVersionUID = -7524146796053335073L;

	//Nom de la compétence
	private String name;
	//Description de la compétence
	private String description;
	//Type de compétence: valorisante/Dévlorisante/Bugei/Marchand
	private String type;
	//CDC:3,Anneaux sur lequelle s'applique la compétance, peut être 'variable'
	private String ring;

}
