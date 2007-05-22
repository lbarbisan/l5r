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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.EditorPart;

/**
 * An editor that presents a chat with a specified participant.
 */
public class PlayerEditor extends EditorPart {

	public static String ID = "l5rgui.editor.PlayerEditor";  //  @jve:decl-index=0:

	private Composite top = null;

	private FormToolkit formToolkit = null;   //  @jve:decl-index=0:visual-constraint=""

	private Composite composite = null;

	private Section section = null;

	private Composite compositeRing = null;

	private Text text = null;

	private Text text1 = null;

	private Label label = null;

	private Label label1 = null;

	private Label label2 = null;

	private Text text2 = null;

	private Label label3 = null;

	private Text text3 = null;

	private Label label4 = null;

	private Text text4 = null;

	private Label label5 = null;

	private Text text5 = null;

	private Label label6 = null;

	private Label label7 = null;

	private Text text6 = null;

	private Text text61 = null;

	private Text text62 = null;

	private Text text63 = null;

	private Label label71 = null;

	private Label label72 = null;

	private Label label8 = null;

	private Text text7 = null;

	private Text text8 = null;

	private Text text9 = null;

	private Text text10 = null;

	private Text text11 = null;

	private Label label9 = null;

	private Label label10 = null;

	private Label label11 = null;

	private Label label12 = null;

	private Section section1 = null;

	private Composite composite1 = null;

	private Section section2 = null;

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		top = new Composite(parent, SWT.NONE);
		createComposite();
		top.setLayout(new FillLayout());
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
		GridLayout gridLayout = new GridLayout();
		gridLayout.makeColumnsEqualWidth = false;
		gridLayout.numColumns = 2;
		composite = getFormToolkit().createComposite(top);
		Label filler = new Label(composite, SWT.NONE);
		createSection2();
		createSection();
		composite.setLayout(gridLayout);
		createSection1();
	}

	/**
	 * This method initializes section	
	 *
	 */
	private void createSection() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.heightHint = 0;
		gridData.widthHint = -1;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		section = getFormToolkit().createSection(
				composite,
				ExpandableComposite.TWISTIE | Section.DESCRIPTION
						| ExpandableComposite.TITLE_BAR);
		section.setExpanded(true);
		section.setText("Anneaux");
		section.setLayoutData(gridData);
		createCompositeRing();
		section.setClient(compositeRing);
	}

	/**
	 * This method initializes compositeRing	
	 *
	 */
	private void createCompositeRing() {
		GridData gridData15 = new GridData();
		gridData15.verticalSpan = 2;
		GridData gridData14 = new GridData();
		gridData14.verticalSpan = 2;
		GridData gridData13 = new GridData();
		gridData13.verticalSpan = 2;
		GridData gridData12 = new GridData();
		gridData12.verticalSpan = 2;
		GridData gridData11 = new GridData();
		gridData11.verticalSpan = 2;
		GridData gridData10 = new GridData();
		gridData10.verticalSpan = 2;
		GridData gridData9 = new GridData();
		gridData9.verticalSpan = 2;
		GridData gridData8 = new GridData();
		gridData8.verticalSpan = 2;
		GridData gridData7 = new GridData();
		gridData7.verticalSpan = 2;
		GridData gridData6 = new GridData();
		gridData6.verticalSpan = 2;
		GridData gridData5 = new GridData();
		gridData5.heightHint = 2;
		gridData5.horizontalSpan = 2;
		gridData5.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData4 = new GridData();
		gridData4.horizontalSpan = 2;
		gridData4.heightHint = 2;
		gridData4.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData3.horizontalSpan = 2;
		gridData3.heightHint = 2;
		GridData gridData2 = new GridData();
		gridData2.horizontalSpan = 2;
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.heightHint = 2;
		gridData2.verticalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		gridData2.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData2.grabExcessVerticalSpace = true;
		GridData gridData1 = new GridData();
		gridData1.horizontalSpan = 4;
		gridData1.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData1.heightHint = 2;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 4;
		compositeRing = getFormToolkit().createComposite(section);
		compositeRing.setLayout(gridLayout1);
		Composite separator = getFormToolkit().createCompositeSeparator(compositeRing);
		separator.setLayoutData(gridData1);
		label8 = getFormToolkit().createLabel(compositeRing, "Label");
		label8.setLayoutData(gridData6);
		text7 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		text7.setLayoutData(gridData7);
		label1 = getFormToolkit().createLabel(compositeRing, "Label");
		text1 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		label = getFormToolkit().createLabel(compositeRing, "Label");
		text = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		Composite separator1 = getFormToolkit().createCompositeSeparator(compositeRing);
		separator1.setLayoutData(gridData2);
		Label filler11 = new Label(compositeRing, SWT.NONE);
		Label filler24 = new Label(compositeRing, SWT.NONE);
		label9 = getFormToolkit().createLabel(compositeRing, "Label");
		label9.setLayoutData(gridData15);
		text8 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		text8.setLayoutData(gridData14);
		label2 = getFormToolkit().createLabel(compositeRing, "Label");
		text2 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		label3 = getFormToolkit().createLabel(compositeRing, "Label");
		text3 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		Composite separator2 = getFormToolkit().createCompositeSeparator(compositeRing);
		separator2.setLayoutData(gridData3);
		Label filler8 = new Label(compositeRing, SWT.NONE);
		Label filler21 = new Label(compositeRing, SWT.NONE);
		label10 = getFormToolkit().createLabel(compositeRing, "Label");
		label10.setLayoutData(gridData13);
		text9 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		text9.setLayoutData(gridData12);
		label4 = getFormToolkit().createLabel(compositeRing, "Label");
		text4 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		label5 = getFormToolkit().createLabel(compositeRing, "Label");
		text5 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		Composite separator3 = getFormToolkit().createCompositeSeparator(compositeRing);
		separator3.setLayoutData(gridData4);
		Label filler5 = new Label(compositeRing, SWT.NONE);
		Label filler18 = new Label(compositeRing, SWT.NONE);
		label11 = getFormToolkit().createLabel(compositeRing, "Label");
		label11.setLayoutData(gridData10);
		text10 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		text10.setLayoutData(gridData11);
		label6 = getFormToolkit().createLabel(compositeRing, "Label");
		text61 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		label7 = getFormToolkit().createLabel(compositeRing, "Label");
		text6 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		Composite separator4 = getFormToolkit().createCompositeSeparator(compositeRing);
		separator4.setLayoutData(gridData5);
		Label filler2 = new Label(compositeRing, SWT.NONE);
		Label filler15 = new Label(compositeRing, SWT.NONE);
		label12 = getFormToolkit().createLabel(compositeRing, "Label");
		label12.setLayoutData(gridData9);
		text11 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		text11.setLayoutData(gridData8);
		label71 = getFormToolkit().createLabel(compositeRing, "Label");
		text62 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
		label72 = getFormToolkit().createLabel(compositeRing, "Label");
		text63 = getFormToolkit().createText(compositeRing, null, SWT.SINGLE | SWT.BORDER);
	}

	/**
	 * This method initializes section1	
	 *
	 */
	private void createSection1() {
		GridData gridData16 = new GridData();
		gridData16.grabExcessHorizontalSpace = true;
		gridData16.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData16.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData16.grabExcessVerticalSpace = true;
		section1 = getFormToolkit().createSection(
				composite,
				ExpandableComposite.TWISTIE | Section.DESCRIPTION
						| ExpandableComposite.TITLE_BAR);
		section1.setExpanded(true);
		createComposite1();
		section1.setLayoutData(gridData16);
		section1.setClient(composite1);
	}

	/**
	 * This method initializes composite1	
	 *
	 */
	private void createComposite1() {
		composite1 = getFormToolkit().createComposite(section1);
		composite1.setLayout(new GridLayout());
	}

	/**
	 * This method initializes section2	
	 *
	 */
	private void createSection2() {
		section2 = getFormToolkit().createSection(
				composite,
				ExpandableComposite.TWISTIE | Section.DESCRIPTION
						| ExpandableComposite.TITLE_BAR);
		section2.setExpanded(true);
		section2.setText("Identité");
	}

	
	public PlayerEditor() {
	}

	public void doSave(IProgressMonitor monitor) {
		// Save not supported
	}

	public void doSaveAs() {
		// Save As not supported
	}

	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
		setPartName(getUser());
	}

	public boolean isDirty() {
		return false;
	}

	public boolean isSaveAsAllowed() {
		// Save As not supported
		return false;
	}

	private String getUser() {
		return ((PlayerEditorInput) getEditorInput()).getName();
	}

	public void dispose() {
	}
}   //  @jve:decl-index=0:visual-constraint="10,10,482,400"
