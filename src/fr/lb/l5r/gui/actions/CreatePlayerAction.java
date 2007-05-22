package fr.lb.l5r.gui.actions;

import java.io.File;
import java.net.URL;
import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.naming.InitialContext;


import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.jboss.ejb3.embedded.EJB3StandaloneBootstrap;
import org.jboss.ejb3.embedded.EJB3StandaloneDeployer;
import org.jboss.ejb3.embedded.KernelErrors;

import fr.lb.l5r.business.beans.interfaces.IEntityLocal;
import fr.lb.l5r.business.entities.PersonnageJoueur;
import fr.lb.l5r.business.entities.interfaces.IEntity;
import fr.lb.l5r.gui.editor.PlayerEditor;
import fr.lb.l5r.gui.editor.PlayerEditorInput;

public class CreatePlayerAction extends Action implements IWorkbenchAction {

	private final static Logger logger = Logger
			.getLogger(CreatePlayerAction.class);

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

			// FIXME: Déplacer l'instantiation du bootstrap
			EJB3StandaloneBootstrap.boot(null);
			try
		      {
				EJB3StandaloneDeployer deployer = EJB3StandaloneBootstrap.createDeployer();
			    File file = new File("G:\\Projects\\L5R\\L5RGui\\");
			    deployer.getDeployDirs().add(file.toURL());

			    deployer.create();
			    deployer.start();
		      }
		      catch (Exception e)
		      {
		         throw new RuntimeException(e);
		      }
		      
			InitialContext ctx;

			ctx = getInitialContext();
			IEntityLocal local = (IEntityLocal) ctx.lookup("EntityBean/local");
			int id = local.create(PersonnageJoueur.class, "name", "Gavin");
			IEntity cust = local.find(PersonnageJoueur.class, id);
			PlayerEditorInput input = new PlayerEditorInput(
					(PersonnageJoueur) cust);
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

	public static InitialContext getInitialContext() throws Exception {
		Hashtable props = getInitialContextProperties();
		return new InitialContext(props);
	}

	private static Hashtable getInitialContextProperties() {
		Hashtable props = new Hashtable();
		props.put("java.naming.factory.initial","org.jnp.interfaces.LocalOnlyContextFactory");
		props.put("java.naming.factory.url.pkgs","org.jboss.naming:org.jnp.interfaces");
		return props;
	}
}
