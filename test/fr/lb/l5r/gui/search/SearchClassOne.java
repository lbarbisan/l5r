package fr.lb.l5r.gui.search;

import org.eclipse.swt.widgets.Text;

public class SearchClassOne {

	private Text txtName;
	private Text txtClan;
	private Text txtSchool;
	
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
	

}
