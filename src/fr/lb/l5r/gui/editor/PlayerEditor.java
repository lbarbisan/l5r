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

	private Section section1 = null;

	private Composite composite1 = null;

	private Section section2 = null;

	private Label lblVoid = null;

	private Text txtVoidRing = null;

	private Text txtVoidRingPointsSpent = null;

	private Label lblVoidPointsSpent = null;

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

		// DataBinding
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
		return ((PlayerEditorInput) getEditorInput()).getName();
	}

	public void dispose() {
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
} // @jve:decl-index=0:visual-constraint="10,10,482,400"
