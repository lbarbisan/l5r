package fr.lb.l5r.gui;


import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import fr.lb.l5r.gui.actions.CreatePlayerAction;
import fr.lb.l5r.gui.actions.OpenSearchPlayerAction;



/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    public static final String M_PLAYER = "player";
    public static final String M_CAMPAIGN = "campaign";
    public static final String M_FIGHT = "fight";
    public static final String M_SCENARIO = "scenario";
	
    // Actions - important to allocate these only in makeActions, and then use them
    // in the fill methods.  This ensures that the actions aren't recreated
    // when fillActionBars is called with FILL_PROXY.
    private IWorkbenchAction exitAction;
    private IWorkbenchAction aboutAction;
    private IWorkbenchAction createPlayerAction;
    private IWorkbenchAction searchPlayerAction;
    

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }
    
    protected void makeActions(final IWorkbenchWindow window) {
        // Creates the actions and registers them.
        // Registering is needed to ensure that key bindings work.
        // The corresponding commands keybindings are defined in the plugin.xml file.
        // Registering also provides automatic disposal of the actions when
        // the window is closed.
        exitAction = ActionFactory.QUIT.create(window);
        register(exitAction);
        aboutAction = ActionFactory.ABOUT.create(window);
        register(aboutAction);
        createPlayerAction = new CreatePlayerAction(window);
        register(createPlayerAction);
        searchPlayerAction = new OpenSearchPlayerAction(window);
        
    }
    
    protected void fillMenuBar(IMenuManager menuBar) {
    	
        MenuManager fileMenu = new MenuManager("&Fichier", IWorkbenchActionConstants.M_FILE);
        MenuManager playerMenu = new MenuManager("&Personnage", ApplicationActionBarAdvisor.M_PLAYER);
        MenuManager campaignMenu = new MenuManager("&Campagne", ApplicationActionBarAdvisor.M_CAMPAIGN);
        MenuManager fightMenu = new MenuManager("&Combat", ApplicationActionBarAdvisor.M_FIGHT);
        MenuManager scenarioMenu = new MenuManager("&Scénario", ApplicationActionBarAdvisor.M_SCENARIO);
        MenuManager helpMenu = new MenuManager("&Aide", IWorkbenchActionConstants.M_HELP);
        
        menuBar.add(fileMenu);
        menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
        menuBar.add(playerMenu);
        menuBar.add(campaignMenu);
        menuBar.add(fightMenu);
        menuBar.add(scenarioMenu);
        // Add a group marker indicating where action set menus will appear.
        menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
        menuBar.add(helpMenu);
        
        // File
        fileMenu.add(exitAction);
        // Player
        playerMenu.add(createPlayerAction);
        playerMenu.add(searchPlayerAction);
        // Help
        helpMenu.add(aboutAction);
    }
    
    protected void fillCoolBar(ICoolBarManager coolBar) {
        IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
        coolBar.add(new ToolBarContributionItem(toolbar, "main"));   
        //toolbar.add(openViewAction);
        //toolbar.add(messagePopupAction);
    }

}
