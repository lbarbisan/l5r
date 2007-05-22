package fr.lb.l5r.gui.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.Assert;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import fr.lb.l5r.business.entities.PersonnageJoueur;

public class PlayerEditorInput implements IEditorInput {
	private PersonnageJoueur personnageJoueur;

	public PlayerEditorInput(PersonnageJoueur personnageJoueur) {
		super();
		Assert.isNotNull(personnageJoueur);
		this.personnageJoueur = personnageJoueur;
	}
	
	public boolean exists() {
		return false;
	}
	//FIXME:  Tooltip ne peut être null
	public String getToolTipText() {
		return "Player" + personnageJoueur.getName();
	}
	//FIXME:  Tooltip ne peut être null
	public String getName() {
		return  "Player" + personnageJoueur.getName();
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
		return this.personnageJoueur.equals(other.personnageJoueur);
	}
	public int hashCode() {
		return personnageJoueur.hashCode();
	}
	public Object getAdapter(Class adapter) {
		return null;
	}
}
