package fr.lb.l5r.gui.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.Assert;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import fr.lb.l5r.business.entities.PersonnageJoueur;
import fr.lb.l5r.business.entities.interfaces.IEntity;

public class SearchPlayerEditorInput implements IEditorInput {

	private IEntity entity;
	
	public SearchPlayerEditorInput(IEntity entity) {
		super();
		Assert.isNotNull(entity);
		this.entity = entity;
	}
	
		
	public boolean exists() {
		return false;
	}
	public String getToolTipText() {
		return "Permet d'effecter une recherche pour trouver un PJ";
	}
	public String getName() {
		return  "Search";
	}
	public ImageDescriptor getImageDescriptor() {
		return null;
	}
	public IPersistableElement getPersistable() {
		return null;
	}
	public Object getAdapter(Class adapter) {
		return null;
	}
}
