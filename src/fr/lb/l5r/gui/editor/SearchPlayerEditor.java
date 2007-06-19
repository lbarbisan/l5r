/*******************************************************************************
 * Copyright (c) 2004, 2005 Jean-Michel Lemieux, Jeff McAffer and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Hyperbola is an RCP application developed for the book 
 *     Eclipse Rich Client Platform - 
 *         Designing, Coding, and Packaging Java Applications 
 *
 * Contributors:
 *     Jean-Michel Lemieux and Jeff McAffer - initial implementation
 *******************************************************************************/
package fr.lb.l5r.gui.editor;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.EditorPart;

import fr.lb.l5r.gui.databindings.DataBindingHelper;
import fr.lb.l5r.gui.editor.input.PlayerEditorInput;
import fr.lb.l5r.gui.editor.input.SearchPlayerEditorInput;
import fr.lb.l5r.gui.search.SearchField;
import org.eclipse.swt.widgets.TableColumn;

/**
 * An editor that presents a chat with a specified participant.
 */
public class SearchPlayerEditor extends EditorPart {

	public static String ID = "l5rgui.editor.SearchPlayerEditor"; // @jve:decl-index=0:

	private Composite top = null;

	private FormToolkit formToolkit = null; // @jve:decl-index=0:visual-constraint=""

	private Composite composite = null;

	private Group group = null;

	private Label lblName = null;

	private Text txtName = null;

	private Label lblClan = null;

	private Text txtClan = null;

	private Label lblSchool = null;

	private Text txtSchool = null;

	private Button button = null;

	private Composite composite1 = null;

	private TableViewer tblSearchResult = null;

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		top = new Composite(parent, SWT.NONE);
		top.setLayout(new FillLayout());
		createComposite2();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	/**
	 * This method initializes formToolkit
	 * 
	 * @return org.eclipse.ui.forms.widgets.FormToolkit
	 */
	private FormToolkit getFormToolkit() {
		if (formToolkit == null) {
			formToolkit = new FormToolkit(Display.getCurrent());
		}
		return formToolkit;
	}

	/**
	 * This method initializes composite
	 * 
	 */
	private void createComposite() {
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				DataBindingContext bindingContext = new DataBindingContext();
				DataBindingHelper
						.bindPojoOnEditor(
								SearchPlayerEditor.this,
								((PlayerEditorInput) SearchPlayerEditor.this
										.getEditorInput()).getPlayerCharacter(),
								bindingContext);
			}
		});
	}

	/**
	 * This method initializes compositeRing
	 * 
	 */
	private void createCompositeRing() {
		GridData gridData8 = new GridData();
		gridData8.verticalSpan = 2;
	}

	public SearchPlayerEditor() {
	}

	public void doSave(IProgressMonitor monitor) {
	}

	public void doSaveAs() {
	}

	public boolean isDirty() {
		return false;
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	private String getUser() {
		return (getEditorInput()).getName();
	}

	public void dispose() {
	}

	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// POST-CONDITION
		if (!(input instanceof SearchPlayerEditorInput))
			throw new PartInitException(
					"Invalid Input: Must be SearchEditorInput");

		// initialisation des variables
		setSite(site);
		setInput(input);
		setPartName(getUser());
	}

	/**
	 * This method initializes composite	
	 *
	 */
	private void createComposite2() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		composite = new Composite(top, SWT.NONE);
		composite.setLayout(new GridLayout());
		createGroup();
		tblSearchResult = new TableViewer(composite, SWT.NONE);
		TableColumn tableColumn = new TableColumn(tblSearchResult.getTable(), SWT.NONE);
		tableColumn.setWidth(60);
		TableColumn tableColumn1 = new TableColumn(tblSearchResult.getTable(), SWT.NONE);
		tableColumn1.setWidth(60);
		TableColumn tableColumn2 = new TableColumn(tblSearchResult.getTable(), SWT.NONE);
		tableColumn2.setWidth(60);
		tblSearchResult.getTable().setHeaderVisible(true);
		tblSearchResult.getTable().setLinesVisible(true);
		tblSearchResult.getTable().setLayoutData(gridData);
	}

	/**
	 * This method initializes group	
	 *
	 */
	private void createGroup() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 8;
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		group = new Group(composite, SWT.NONE);
		group.setText("Criteria :");
		group.setLayout(gridLayout);
		group.setLayoutData(gridData1);
		lblName = new Label(group, SWT.NONE);
		lblName.setText("Name");
		txtName = new Text(group, SWT.BORDER);
		lblClan = new Label(group, SWT.NONE);
		lblClan.setText("Clan");
		txtClan = new Text(group, SWT.BORDER);
		lblSchool = new Label(group, SWT.NONE);
		lblSchool.setText("School");
		txtSchool = new Text(group, SWT.BORDER);
		createComposite1();
		button = new Button(group, SWT.NONE);
		button.setText("Search");
		button.addMouseListener(new org.eclipse.swt.events.MouseAdapter() {
			public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
				((SearchPlayerEditorInput) SearchPlayerEditor.this.getEditorInput()).search(SearchPlayerEditor.this);
				System.out.println("mouseUp()"); // TODO Auto-generated Event stub mouseUp()
			}
		});
	}

	/**
	 * This method initializes composite1	
	 *
	 */
	private void createComposite1() {
		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = true;
		composite1 = new Composite(group, SWT.NONE);
		composite1.setLayout(new GridLayout());
		composite1.setLayoutData(gridData2);
	}

	/**
	 * @return the txtClan
	 */
	@SearchField
	public Text getTxtClan() {
		return txtClan;
	}

	/**
	 * @return the txtName
	 */
	@SearchField
	public Text getTxtName() {
		return txtName;
	}

	/**
	 * @return the txtSchool
	 */
	@SearchField
	public Text getTxtSchool() {
		return txtSchool;
	}

	/**
	 * @return the tblSearchResult
	 */
	public TableViewer getTblSearchResult() {
		return tblSearchResult;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10,727,546"
