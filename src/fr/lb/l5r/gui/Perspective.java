package fr.lb.l5r.gui;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		//String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		//layout.addStandaloneView(View.ID,  false, IPageLayout.LEFT, 1.0f, editorArea);
	}

}
