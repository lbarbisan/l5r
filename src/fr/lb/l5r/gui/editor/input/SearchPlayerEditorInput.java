package fr.lb.l5r.gui.editor.input;

import java.util.Collection;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.Assert;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import fr.lb.l5r.business.beans.EntityBean;
import fr.lb.l5r.business.beans.interfaces.IEntityLocal;
import fr.lb.l5r.business.entities.PersonnageJoueur;
import fr.lb.l5r.gui.editor.SearchPlayerEditor;
import fr.lb.l5r.gui.providers.EntityTableLabelProvider;
import fr.lb.l5r.gui.search.SearchHelper;

public class SearchPlayerEditorInput implements IEditorInput {

	private IEntityLocal entity;
	
	public SearchPlayerEditorInput(IEntityLocal entity) {
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


	public void search(SearchPlayerEditor editor) {
		Collection entities = entity.find(PersonnageJoueur.class, SearchHelper.retrieveSearchField(editor));
		editor.getTblSearchResult().setContentProvider(new ArrayContentProvider());
		editor.getTblSearchResult().setLabelProvider(new EntityTableLabelProvider<PersonnageJoueur>("name", "clan", "school"));
		editor.getTblSearchResult().setInput(entities);
	}
}
