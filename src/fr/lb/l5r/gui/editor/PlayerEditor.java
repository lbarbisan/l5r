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

import fr.lb.l5r.gui.databindings.DataBindingHelper;
import fr.lb.l5r.gui.editor.input.PlayerEditorInput;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.graphics.Font;

/**
 * An editor that presents a chat with a specified participant.
 */
public class PlayerEditor extends EditorPart {

	public static String ID = "l5rgui.editor.PlayerEditor"; // @jve:decl-index=0:

	private Composite top = null;

	private FormToolkit formToolkit = null; // @jve:decl-index=0:visual-constraint=""

	private Composite composite = null;

	private Section section = null;

	private Composite compositeRing = null;

	private Text txtWillPower = null;

	private Text txtStamina = null;

	private Label lblWillPower = null;

	private Label lblStamina = null;

	private Label lblStrength = null;

	private Text txtStrength = null;

	private Label lblPerception = null;

	private Text txtPerception = null;

	private Label lblAgility = null;

	private Text txtAgility = null;

	private Label lblIntelligence = null;

	private Text txtIntelligence = null;

	private Label lblReflexes = null;

	private Label lblAwareness = null;

	private Text txtAwareness = null;

	private Text txtReflexes = null;

	private Label lblEarth = null;

	private Text txtEarthRing = null;

	private Text txtWaterRing = null;

	private Text txtFireRing = null;

	private Text txtAirRing = null;

	private Label lblWater = null;

	private Label lblFire = null;

	private Label lblAir = null;

	private Section section2 = null;

	private Label lblVoid = null;

	private Text txtVoidRing = null;

	private Text txtVoidRingPointsSpent = null;

	private Label lblVoidPointsSpent = null;

	private Composite composite2 = null;

	private Label lblName = null;

	private Text txtName = null;

	private Label lblClan = null;

	private Label lblRank = null;

	private Text txtClan = null;

	private Text txtRank = null;

	private Label lblSchool = null;

	private Label lblInsight = null;

	private Text txtSchool = null;

	private Text txtInsight = null;

	private Section section3 = null;

	private Composite composite3 = null;

	private Button checkBox = null;

	private Button checkBox1 = null;

	private Button checkBox11 = null;

	private Button checkBox12 = null;

	private Button checkBox13 = null;

	private Button checkBox14 = null;

	private Button checkBox15 = null;

	private Button checkBox16 = null;

	private Button checkBox17 = null;

	private Button checkBox18 = null;

	private Text text5 = null;

	private Section section1 = null;

	private Table table = null;

	private Section section4 = null;

	private Table table1 = null;

	private Section section5 = null;

	private Composite composite1 = null;

	private Label label = null;

	private Text text = null;

	private Label label1 = null;

	private Text text1 = null;

	private Text text2 = null;

	private Label label2 = null;

	private Text text3 = null;

	private Label label3 = null;

	private Section section6 = null;

	private Composite composite4 = null;

	private Label label4 = null;

	private Label label5 = null;

	private Label label6 = null;

	private Text text4 = null;

	private Text text6 = null;

	private Text text7 = null;

	private Section section7 = null;

	private Composite composite5 = null;

	private Text text8 = null;

	private Text text9 = null;

	private Label label7 = null;

	private Label label8 = null;

	private Section section8 = null;

	private Composite composite6 = null;

	private Text text10 = null;

	private Text text11 = null;

	private Label label9 = null;

	private Label label10 = null;

	private Section section9 = null;

	private Table table2 = null;

	private Composite composite7 = null;


	public PlayerEditor() {
	}
	
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// POST-CONDITION
		if (!(input instanceof PlayerEditorInput))
			throw new PartInitException(
					"Invalid Input: Must be PlayerEditorInput");
	
		// initialisation des variables
		setSite(site);
		setInput(input);
		setPartName(getUser());
	}

	public boolean isDirty() {
		return true;
	}
	public boolean isSaveAsAllowed() {
		return false;
	}
	public void doSave(IProgressMonitor monitor) {
		
		((PlayerEditorInput) getEditorInput()).save();
	}
	public void doSaveAs() {
	}
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	public void dispose() {
	}

	private String getUser() {
		return ((PlayerEditorInput) getEditorInput()).getName();
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

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		top = new Composite(parent, SWT.NONE);
		top.setLayout(new FillLayout());
		createComposite();
	}
	/**
	 * This method initializes composite
	 * 
	 */
	private void createComposite() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.makeColumnsEqualWidth = false;
		gridLayout.numColumns = 5;
		composite = getFormToolkit().createComposite(top);
		createSection2();
		createComposite7();
		createSection5();
		createSection6();
		createSection7();
		createSection8();
		Label filler1 = new Label(composite, SWT.NONE);
		createSection();
		createSection1();
		createSection9();
		composite.setLayout(gridLayout);
		createSection4();
		createSection3();
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				DataBindingContext bindingContext = new DataBindingContext();
				DataBindingHelper
						.bindPojoOnEditor(
								PlayerEditor.this,
								((PlayerEditorInput) PlayerEditor.this
										.getEditorInput()).getPlayerCharacter(),
								bindingContext);
			}
		});
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
		gridData.horizontalSpan = 2;
		gridData.grabExcessVerticalSpace = true;
		section = getFormToolkit().createSection(
				composite,
				ExpandableComposite.TWISTIE | Section.DESCRIPTION
						| ExpandableComposite.TITLE_BAR);
		section.setExpanded(true);
		section.setText("Anneaux");
		section.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD));
		section.setLayoutData(gridData);
		createCompositeRing();
		section.setClient(compositeRing);
	}

	/**
	 * This method initializes compositeRing
	 * 
	 */
	private void createCompositeRing() {
		GridData gridData25 = new GridData();
		gridData25.grabExcessHorizontalSpace = true;
		gridData25.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData24 = new GridData();
		gridData24.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData24.grabExcessHorizontalSpace = true;
		GridData gridData23 = new GridData();
		gridData23.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData22 = new GridData();
		gridData22.grabExcessHorizontalSpace = true;
		gridData22.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData21 = new GridData();
		gridData21.grabExcessHorizontalSpace = true;
		gridData21.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData20 = new GridData();
		gridData20.grabExcessHorizontalSpace = true;
		gridData20.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData19 = new GridData();
		gridData19.grabExcessHorizontalSpace = true;
		gridData19.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData18 = new GridData();
		gridData18.grabExcessHorizontalSpace = true;
		gridData18.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData17 = new GridData();
		gridData17.grabExcessHorizontalSpace = true;
		gridData17.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData9 = new GridData();
		gridData9.grabExcessHorizontalSpace = true;
		gridData9.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData15 = new GridData();
		gridData15.verticalSpan = 2;
		GridData gridData14 = new GridData();
		gridData14.verticalSpan = 2;
		gridData14.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData14.grabExcessHorizontalSpace = true;
		GridData gridData13 = new GridData();
		gridData13.verticalSpan = 2;
		GridData gridData12 = new GridData();
		gridData12.verticalSpan = 2;
		gridData12.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData12.grabExcessHorizontalSpace = true;
		GridData gridData11 = new GridData();
		gridData11.verticalSpan = 2;
		gridData11.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData11.grabExcessHorizontalSpace = true;
		GridData gridData10 = new GridData();
		gridData10.verticalSpan = 2;
		GridData gridData8 = new GridData();
		gridData8.verticalSpan = 2;
		GridData gridData7 = new GridData();
		gridData7.verticalSpan = 2;
		gridData7.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData7.grabExcessHorizontalSpace = true;
		GridData gridData6 = new GridData();
		gridData6.verticalSpan = 2;
		GridData gridData5 = new GridData();
		gridData5.heightHint = 2;
		gridData5.horizontalSpan = 4;
		gridData5.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData4 = new GridData();
		gridData4.horizontalSpan = 4;
		gridData4.heightHint = 2;
		gridData4.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData3.horizontalSpan = 4;
		gridData3.heightHint = 2;
		GridData gridData2 = new GridData();
		gridData2.horizontalSpan = 4;
		gridData2.grabExcessHorizontalSpace = false;
		gridData2.heightHint = 2;
		gridData2.verticalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		gridData2.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData2.grabExcessVerticalSpace = false;
		GridData gridData1 = new GridData();
		gridData1.horizontalSpan = 4;
		gridData1.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData1.heightHint = 2;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 4;
		compositeRing = getFormToolkit().createComposite(section);
		compositeRing.setLayout(gridLayout1);
		Composite separator = getFormToolkit().createCompositeSeparator(
				compositeRing);
		separator.setLayoutData(gridData1);
		lblEarth = getFormToolkit().createLabel(compositeRing, "earth");
		lblEarth.setLayoutData(gridData6);
		txtEarthRing = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtEarthRing.setLayoutData(gridData7);
		lblStamina = getFormToolkit().createLabel(compositeRing, "Stamina");
		txtStamina = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtStamina.setLayoutData(gridData9);
		lblWillPower = getFormToolkit().createLabel(compositeRing, "WillPower");
		txtWillPower = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtWillPower.setLayoutData(gridData17);
		Composite separator1 = getFormToolkit().createCompositeSeparator(
				compositeRing);
		separator1.setLayoutData(gridData2);
		lblWater = getFormToolkit().createLabel(compositeRing, "water");
		lblWater.setLayoutData(gridData15);
		txtWaterRing = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtWaterRing.setLayoutData(gridData14);
		lblStrength = getFormToolkit().createLabel(compositeRing, "Strength");
		txtStrength = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtStrength.setLayoutData(gridData18);
		lblPerception = getFormToolkit().createLabel(compositeRing,
				"Perception");
		txtPerception = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtPerception.setLayoutData(gridData19);
		Composite separator2 = getFormToolkit().createCompositeSeparator(
				compositeRing);
		separator2.setLayoutData(gridData3);
		lblFire = getFormToolkit().createLabel(compositeRing, "Fire");
		lblFire.setLayoutData(gridData13);
		txtFireRing = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtFireRing.setLayoutData(gridData12);
		lblAgility = getFormToolkit().createLabel(compositeRing, "Agility");
		txtAgility = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtAgility.setLayoutData(gridData20);
		lblIntelligence = getFormToolkit().createLabel(compositeRing,
				"Intelligence");
		txtIntelligence = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtIntelligence.setLayoutData(gridData23);
		Composite separator3 = getFormToolkit().createCompositeSeparator(
				compositeRing);
		separator3.setLayoutData(gridData4);
		lblAir = getFormToolkit().createLabel(compositeRing, "Air");
		lblAir.setLayoutData(gridData10);
		txtAirRing = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtAirRing.setLayoutData(gridData11);
		lblReflexes = getFormToolkit().createLabel(compositeRing, "Reflexes");
		txtReflexes = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtReflexes.setLayoutData(gridData21);
		lblAwareness = getFormToolkit().createLabel(compositeRing, "Awareness");
		txtAwareness = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtAwareness.setLayoutData(gridData22);
		Composite separator4 = getFormToolkit().createCompositeSeparator(
				compositeRing);
		separator4.setLayoutData(gridData5);
		lblVoid = getFormToolkit().createLabel(compositeRing, "Void");
		txtVoidRing = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtVoidRing.setLayoutData(gridData24);
		lblVoidPointsSpent = getFormToolkit().createLabel(compositeRing,
				"PointsSpent");
		txtVoidRingPointsSpent = getFormToolkit().createText(compositeRing, null,
				SWT.SINGLE | SWT.BORDER);
		txtVoidRingPointsSpent.setLayoutData(gridData25);
	}

	/**
	 * This method initializes section2
	 * 
	 */
	private void createSection2() {
		GridData gridData26 = new GridData();
		gridData26.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData26.grabExcessVerticalSpace = true;
		gridData26.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData26.horizontalSpan = 2;
		gridData26.grabExcessHorizontalSpace = true;
		section2 = getFormToolkit().createSection(
				composite,
				ExpandableComposite.TWISTIE | Section.DESCRIPTION
						| ExpandableComposite.TITLE_BAR);
		section2.setExpanded(true);
		section2.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD));
		createComposite2();
		section2.setText("Identité");
		section2.setLayoutData(gridData26);
		section2.setClient(composite2);
	}

	/**
	 * This method initializes composite2	
	 *
	 */
	private void createComposite2() {
		GridData gridData31 = new GridData();
		gridData31.grabExcessHorizontalSpace = true;
		GridData gridData30 = new GridData();
		gridData30.grabExcessHorizontalSpace = true;
		GridData gridData29 = new GridData();
		gridData29.grabExcessHorizontalSpace = true;
		GridData gridData28 = new GridData();
		gridData28.grabExcessHorizontalSpace = true;
		GridData gridData27 = new GridData();
		gridData27.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData27.horizontalSpan = 3;
		gridData27.grabExcessHorizontalSpace = true;
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 4;
		composite2 = getFormToolkit().createComposite(section2);
		composite2.setLayout(gridLayout2);
		lblName = getFormToolkit().createLabel(composite2, "Name");
		txtName = getFormToolkit().createText(composite2, null, SWT.SINGLE | SWT.BORDER);
		txtName.setLayoutData(gridData27);
		lblClan = getFormToolkit().createLabel(composite2, "Clan");
		txtClan = getFormToolkit().createText(composite2, null, SWT.SINGLE | SWT.BORDER);
		txtClan.setLayoutData(gridData28);
		lblSchool = getFormToolkit().createLabel(composite2, "School");
		txtSchool = getFormToolkit().createText(composite2, null, SWT.SINGLE | SWT.BORDER);
		txtSchool.setLayoutData(gridData30);
		lblRank = getFormToolkit().createLabel(composite2, "Rank");
		txtRank = getFormToolkit().createText(composite2, null, SWT.SINGLE | SWT.BORDER);
		txtRank.setLayoutData(gridData29);
		lblInsight = getFormToolkit().createLabel(composite2, "Insight");
		txtInsight = getFormToolkit().createText(composite2, null, SWT.SINGLE | SWT.BORDER);
		txtInsight.setLayoutData(gridData31);
	}

	/**
	 * This method initializes section3	
	 *
	 */
	private void createSection3() {
		GridData gridData32 = new GridData();
		gridData32.horizontalAlignment = GridData.CENTER;
		gridData32.widthHint = -1;
		gridData32.heightHint = -1;
		section3 = getFormToolkit().createSection(composite, ExpandableComposite.TWISTIE | ExpandableComposite.SHORT_TITLE_BAR);
		section3.setExpanded(true);
		section3.setText("Gloire");
		section3.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD));
		createComposite3();
		section3.setLayoutData(gridData32);
		section3.setClient(composite3);
	}

	/**
	 * This method initializes composite3	
	 *
	 */
	private void createComposite3() {
		GridData gridData44 = new GridData();
		gridData44.horizontalSpan = 5;
		gridData44.grabExcessHorizontalSpace = true;
		gridData44.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData43 = new GridData();
		gridData43.horizontalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		GridData gridData42 = new GridData();
		gridData42.horizontalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		GridData gridData41 = new GridData();
		gridData41.horizontalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		GridData gridData40 = new GridData();
		gridData40.horizontalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		GridData gridData39 = new GridData();
		gridData39.horizontalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		GridData gridData38 = new GridData();
		gridData38.horizontalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		GridData gridData37 = new GridData();
		gridData37.horizontalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		GridData gridData36 = new GridData();
		gridData36.horizontalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		GridData gridData35 = new GridData();
		gridData35.horizontalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		GridData gridData34 = new GridData();
		gridData34.horizontalAlignment = org.eclipse.swt.layout.GridData.CENTER;
		gridData34.grabExcessHorizontalSpace = false;
		GridLayout gridLayout3 = new GridLayout();
		gridLayout3.numColumns = 5;
		gridLayout3.marginHeight = 0;
		gridLayout3.marginWidth = 0;
		gridLayout3.verticalSpacing = 0;
		gridLayout3.makeColumnsEqualWidth = true;
		gridLayout3.horizontalSpacing = 1;
		composite3 = getFormToolkit().createComposite(section3);
		composite3.setLayout(gridLayout3);
		text5 = getFormToolkit().createText(composite3, null, SWT.SINGLE | SWT.BORDER);
		text5.setLayoutData(gridData44);
		checkBox = getFormToolkit().createButton(composite3, null, SWT.CHECK);
		checkBox.setLayoutData(gridData42);
		checkBox1 = getFormToolkit().createButton(composite3, null, SWT.CHECK);
		checkBox1.setLayoutData(gridData40);
		checkBox11 = getFormToolkit().createButton(composite3, null, SWT.CHECK);
		checkBox11.setLayoutData(gridData39);
		checkBox12 = getFormToolkit().createButton(composite3, null, SWT.CHECK);
		checkBox12.setLayoutData(gridData37);
		checkBox13 = getFormToolkit().createButton(composite3, null, SWT.CHECK);
		checkBox13.setLayoutData(gridData34);
		checkBox14 = getFormToolkit().createButton(composite3, null, SWT.CHECK);
		checkBox14.setLayoutData(gridData43);
		checkBox15 = getFormToolkit().createButton(composite3, null, SWT.CHECK);
		checkBox15.setLayoutData(gridData41);
		checkBox16 = getFormToolkit().createButton(composite3, null, SWT.CHECK);
		checkBox16.setLayoutData(gridData38);
		checkBox17 = getFormToolkit().createButton(composite3, null, SWT.CHECK);
		checkBox17.setLayoutData(gridData36);
		checkBox18 = getFormToolkit().createButton(composite3, null, SWT.CHECK);
		checkBox18.setLayoutData(gridData35);
	}

	/**
	 * This method initializes section1	
	 *
	 */
	private void createSection1() {
		GridData gridData16 = new GridData();
		gridData16.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData16.horizontalSpan = 3;
		gridData16.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		section1 = getFormToolkit().createSection(composite, ExpandableComposite.TWISTIE | Section.DESCRIPTION | ExpandableComposite.TITLE_BAR);
		section1.setExpanded(true);
		section1.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD));
		section1.setLayoutData(gridData16);
		section1.setText("Skills");
		table = getFormToolkit().createTable(section1, SWT.NONE);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(140);
		tableColumn.setText("SkillName");
		TableColumn tableColumn1 = new TableColumn(table, SWT.NONE);
		tableColumn1.setWidth(140);
		tableColumn1.setText("SkillEmphasis");
		TableColumn tableColumn2 = new TableColumn(table, SWT.NONE);
		tableColumn2.setWidth(60);
		tableColumn2.setText("SkillRank");
		TableColumn tableColumn3 = new TableColumn(table, SWT.NONE);
		tableColumn3.setWidth(20);
		section1.setClient(table);
	}

	/**
	 * This method initializes section4	
	 *
	 */
	private void createSection4() {
		GridData gridData33 = new GridData();
		gridData33.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData33.horizontalSpan = 3;
		gridData33.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		section4 = getFormToolkit().createSection(composite, ExpandableComposite.TWISTIE | Section.DESCRIPTION | ExpandableComposite.TITLE_BAR);
		section4.setExpanded(true);
		section4.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD));
		section4.setLayoutData(gridData33);
		section4.setText("Mastery Ability");
		table1 = getFormToolkit().createTable(section4, SWT.NONE);
		table1.setHeaderVisible(true);
		table1.setLinesVisible(true);
		TableColumn tableColumn4 = new TableColumn(table1, SWT.NONE);
		tableColumn4.setWidth(200);
		tableColumn4.setText("Description");
		section4.setClient(table1);
	}

	/**
	 * This method initializes section5	
	 *
	 */
	private void createSection5() {
		GridData gridData48 = new GridData();
		gridData48.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData48.verticalSpan = 2;
		gridData48.horizontalAlignment = org.eclipse.swt.layout.GridData.END;
		section5 = getFormToolkit().createSection(composite, ExpandableComposite.TWISTIE | Section.DESCRIPTION | ExpandableComposite.TITLE_BAR);
		section5.setExpanded(true);
		section5.setText("Primary Weapon");
		createComposite1();
		section5.setLayoutData(gridData48);
		section5.setClient(composite1);
	}

	/**
	 * This method initializes composite1	
	 *
	 */
	private void createComposite1() {
		GridLayout gridLayout4 = new GridLayout();
		gridLayout4.numColumns = 2;
		composite1 = getFormToolkit().createComposite(section5);
		composite1.setLayout(gridLayout4);
		label = getFormToolkit().createLabel(composite1, "Label");
		text = getFormToolkit().createText(composite1, null, SWT.SINGLE | SWT.BORDER);
		label1 = getFormToolkit().createLabel(composite1, "Label");
		text1 = getFormToolkit().createText(composite1, null, SWT.SINGLE | SWT.BORDER);
		label2 = getFormToolkit().createLabel(composite1, "Label");
		text2 = getFormToolkit().createText(composite1, null, SWT.SINGLE | SWT.BORDER);
		label3 = getFormToolkit().createLabel(composite1, "Label");
		text3 = getFormToolkit().createText(composite1, null, SWT.SINGLE | SWT.BORDER);
	}

	/**
	 * This method initializes section6	
	 *
	 */
	private void createSection6() {
		GridData gridData49 = new GridData();
		gridData49.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData49.verticalSpan = 2;
		gridData49.horizontalAlignment = org.eclipse.swt.layout.GridData.END;
		section6 = getFormToolkit().createSection(composite, ExpandableComposite.TWISTIE | Section.DESCRIPTION | ExpandableComposite.TITLE_BAR);
		section6.setExpanded(true);
		section6.setText("Armor");
		createComposite4();
		section6.setLayoutData(gridData49);
		section6.setClient(composite4);
	}

	/**
	 * This method initializes composite4	
	 *
	 */
	private void createComposite4() {
		GridLayout gridLayout5 = new GridLayout();
		gridLayout5.numColumns = 2;
		composite4 = getFormToolkit().createComposite(section6);
		composite4.setLayout(gridLayout5);
		label4 = getFormToolkit().createLabel(composite4, "Label");
		text4 = getFormToolkit().createText(composite4, null, SWT.SINGLE | SWT.BORDER);
		label5 = getFormToolkit().createLabel(composite4, "Label");
		text6 = getFormToolkit().createText(composite4, null, SWT.SINGLE | SWT.BORDER);
		label6 = getFormToolkit().createLabel(composite4, "Label");
		text7 = getFormToolkit().createText(composite4, null, SWT.SINGLE | SWT.BORDER);
	}

	/**
	 * This method initializes section7	
	 *
	 */
	private void createSection7() {
		GridData gridData47 = new GridData();
		gridData47.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		section7 = getFormToolkit().createSection(composite, ExpandableComposite.TWISTIE | Section.DESCRIPTION | ExpandableComposite.TITLE_BAR);
		section7.setExpanded(true);
		section7.setText("TNToBeHit");
		createComposite5();
		section7.setLayoutData(gridData47);
		section7.setClient(composite5);
	}

	/**
	 * This method initializes composite5	
	 *
	 */
	private void createComposite5() {
		GridLayout gridLayout6 = new GridLayout();
		gridLayout6.numColumns = 2;
		composite5 = getFormToolkit().createComposite(section7);
		composite5.setLayout(gridLayout6);
		label7 = getFormToolkit().createLabel(composite5, "Label");
		text8 = getFormToolkit().createText(composite5, null, SWT.SINGLE | SWT.BORDER);
		label8 = getFormToolkit().createLabel(composite5, "Label");
		text9 = getFormToolkit().createText(composite5, null, SWT.SINGLE | SWT.BORDER);
	}

	/**
	 * This method initializes section8	
	 *
	 */
	private void createSection8() {
		GridData gridData46 = new GridData();
		gridData46.verticalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gridData46.horizontalAlignment = org.eclipse.swt.layout.GridData.END;
		section8 = getFormToolkit().createSection(composite, ExpandableComposite.TWISTIE | Section.DESCRIPTION | ExpandableComposite.TITLE_BAR);
		section8.setExpanded(true);
		createComposite6();
		section8.setText("Initiative");
		section8.setLayoutData(gridData46);
		section8.setClient(composite6);
	}

	/**
	 * This method initializes composite6	
	 *
	 */
	private void createComposite6() {
		GridLayout gridLayout7 = new GridLayout();
		gridLayout7.numColumns = 2;
		composite6 = getFormToolkit().createComposite(section8);
		composite6.setLayout(gridLayout7);
		label9 = getFormToolkit().createLabel(composite6, "Label");
		text10 = getFormToolkit().createText(composite6, null, SWT.SINGLE | SWT.BORDER);
		label10 = getFormToolkit().createLabel(composite6, "Label");
		text11 = getFormToolkit().createText(composite6, null, SWT.SINGLE | SWT.BORDER);
	}

	/**
	 * This method initializes section9	
	 *
	 */
	private void createSection9() {
		GridData gridData45 = new GridData();
		gridData45.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData45.horizontalSpan = 2;
		gridData45.verticalSpan = 2;
		gridData45.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		section9 = getFormToolkit().createSection(composite, ExpandableComposite.TWISTIE | Section.DESCRIPTION | ExpandableComposite.TITLE_BAR);
		section9.setExpanded(true);
		section9.setText("Wounds");
		section9.setLayoutData(gridData45);
		table2 = new Table(section9, SWT.NONE);
		table2.setHeaderVisible(true);
		table2.setLinesVisible(true);
		TableColumn tableColumn5 = new TableColumn(table2, SWT.NONE);
		tableColumn5.setWidth(60);
		tableColumn5.setText("Wounds");
		TableColumn tableColumn6 = new TableColumn(table2, SWT.NONE);
		tableColumn6.setWidth(60);
		tableColumn6.setText("Total");
		TableColumn tableColumn7 = new TableColumn(table2, SWT.NONE);
		tableColumn7.setWidth(60);
		tableColumn7.setText("Current");
		section9.setClient(table2);
	}

	/**
	 * This method initializes composite7	
	 *
	 */
	private void createComposite7() {
		GridData gridData50 = new GridData();
		gridData50.grabExcessHorizontalSpace = true;
		composite7 = getFormToolkit().createComposite(composite);
		composite7.setLayout(new GridLayout());
		composite7.setLayoutData(gridData50);
	}

	/**
	 * @return the txtAgility
	 */
	public Text getTxtAgility() {
		return txtAgility;
	}

	/**
	 * @return the txtAirRing
	 */
	public Text getTxtAirRing() {
		return txtAirRing;
	}

	/**
	 * @return the txtAwareness
	 */
	public Text getTxtAwareness() {
		return txtAwareness;
	}

	/**
	 * @return the txtEarthRing
	 */
	public Text getTxtEarthRing() {
		return txtEarthRing;
	}

	/**
	 * @return the txtFireRing
	 */
	public Text getTxtFireRing() {
		return txtFireRing;
	}

	/**
	 * @return the txtIntelligence
	 */
	public Text getTxtIntelligence() {
		return txtIntelligence;
	}

	/**
	 * @return the txtPerception
	 */
	public Text getTxtPerception() {
		return txtPerception;
	}

	/**
	 * @return the txtVoidRingPointsSpent
	 */
	public Text getTxtVoidRingPointsSpent() {
		return txtVoidRingPointsSpent;
	}

	/**
	 * @return the txtReflexes
	 */
	public Text getTxtReflexes() {
		return txtReflexes;
	}

	/**
	 * @return the txtStamina
	 */
	public Text getTxtStamina() {
		return txtStamina;
	}

	/**
	 * @return the txtStrength
	 */
	public Text getTxtStrength() {
		return txtStrength;
	}

	/**
	 * @return the txtVoidRing
	 */
	public Text getTxtVoidRing() {
		return txtVoidRing;
	}

	/**
	 * @return the txtWaterRing
	 */
	public Text getTxtWaterRing() {
		return txtWaterRing;
	}

	/**
	 * @return the txtWillPower
	 */
	public Text getTxtWillPower() {
		return txtWillPower;
	}

	/**
	 * @return the txtClan
	 */
	public Text getTxtClan() {
		return txtClan;
	}

	/**
	 * @return the txtName
	 */
	public Text getTxtName() {
		return txtName;
	}

	/**
	 * @return the txtSchool
	 */
	public Text getTxtSchool() {
		return txtSchool;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10,727,546"
