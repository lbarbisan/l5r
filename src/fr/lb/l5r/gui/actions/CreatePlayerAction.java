package fr.lb.l5r.gui.actions;

import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import fr.lb.l5r.business.Configuration;
import fr.lb.l5r.business.beans.interfaces.IEntityLocal;
import fr.lb.l5r.business.entities.PersonnageJoueur;
import fr.lb.l5r.business.entities.interfaces.IEntity;
import fr.lb.l5r.gui.editor.PlayerEditor;
import fr.lb.l5r.gui.editor.input.PlayerEditorInput;

public class CreatePlayerAction extends Action implements IWorkbenchAction {

	private final static Logger logger = Logger.getLogger(CreatePlayerAction.class);
	
	public final static String ID = "l5rgui.player";

	private final IWorkbenchWindow window;

	public CreatePlayerAction(IWorkbenchWindow window) {
		this.window = window;
		setId(ID);
		setText("&Créer un personnage...");
		setToolTipText("Permet de créer un personnage complet.");
	}

	public void run() {
		try {
			IWorkbenchPage page = window.getActivePage();
			InitialContext context =  Configuration.getInstance().getContext();
			IEntityLocal local = (IEntityLocal) context.lookup("EntityBean/local");
			PersonnageJoueur player = (PersonnageJoueur) local.create(PersonnageJoueur.class);
			PlayerEditorInput input = new PlayerEditorInput(player);
			
			page.openEditor(input, PlayerEditor.ID);
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
