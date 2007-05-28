package fr.lb.l5r.gui.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.Assert;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import fr.lb.l5r.business.entities.PersonnageJoueur;

public class PlayerEditorInput implements IEditorInput {
	private PersonnageJoueur playerCharacter;

	public PlayerEditorInput(PersonnageJoueur playerCharacter) {
		super();
		Assert.isNotNull(playerCharacter);
		this.playerCharacter = playerCharacter;
	}
	
	public boolean exists() {
		return false;
	}
	//FIXME:  Tooltip ne peut être null
	public String getToolTipText() {
		return "Player" + playerCharacter.getName();
	}
	//FIXME:  Tooltip ne peut être null
	public String getName() {
		return  "Player" + playerCharacter.getName();
	}
	public ImageDescriptor getImageDescriptor() {
		return null;
	}
	public IPersistableElement getPersistable() {
		return null;
	}
	public boolean equals(Object obj) {
		if (super.equals(obj))
			return true;
		if (!(obj instanceof PlayerEditorInput))
			return false;
		PlayerEditorInput other = (PlayerEditorInput) obj;
		return this.playerCharacter.equals(other.playerCharacter);
	}
	public int hashCode() {
		return playerCharacter.hashCode();
	}
	public Object getAdapter(Class adapter) {
		return null;
	}

	/**
	 * @return the playerCharacter
	 */
	public PersonnageJoueur getPlayerCharacter() {
		return playerCharacter;
	}

	/**
	 * @param playerCharacter the playerCharacter to set
	 */
	public void setPlayerCharacter(PersonnageJoueur playerCharacter) {
		this.playerCharacter = playerCharacter;
	}
}
