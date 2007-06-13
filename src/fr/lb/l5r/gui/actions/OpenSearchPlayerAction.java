package fr.lb.l5r.gui.actions;

import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import fr.lb.l5r.business.Configuration;
import fr.lb.l5r.business.beans.EntityBean;
import fr.lb.l5r.business.beans.interfaces.IEntityLocal;
import fr.lb.l5r.business.entities.PersonnageJoueur;
import fr.lb.l5r.business.entities.interfaces.IEntity;
import fr.lb.l5r.gui.editor.PlayerEditor;
import fr.lb.l5r.gui.editor.SearchPlayerEditor;
import fr.lb.l5r.gui.editor.input.PlayerEditorInput;
import fr.lb.l5r.gui.editor.input.SearchPlayerEditorInput;

public class OpenSearchPlayerAction extends Action implements IWorkbenchAction {

	private final static Logger logger = Logger.getLogger(OpenSearchPlayerAction.class);
	
	public final static String ID = "l5rgui.player";

	private final IWorkbenchWindow window;

	public OpenSearchPlayerAction(IWorkbenchWindow window) {
		this.window = window;
		setId(ID);
		setText("&Rechercher un personnage...");
		setToolTipText("Permet de retrouver la liste des PJ/PNJ existant.");
	}

	public void run() {
		try {
			IWorkbenchPage page = window.getActivePage();
			InitialContext context =  Configuration.getInstance().getContext();
			IEntityLocal local = (IEntityLocal) context.lookup("EntityBean/local");
			SearchPlayerEditorInput input = new SearchPlayerEditorInput(local);
			page.openEditor(input, SearchPlayerEditor.ID);
		} catch (PartInitException e) {
			logger.error(e);
		} catch (Exception e1) {
			logger.error(e1);
		}
	}

	public void dispose() {
		// NE FAIS RIEN
	}
}
