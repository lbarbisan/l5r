/**
 * 
 */
package fr.lb.l5r.gui.providers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import fr.lb.l5r.business.entities.interfaces.IEntity;
import fr.lb.l5r.gui.search.SearchHelper;

/**
 * Cette classe est le provider par défaut d'un objet métier
 * @author Laurent BARBISAN
 *
 */
public class EntityTableLabelProvider<T extends IEntity> extends LabelProvider implements ITableLabelProvider {

	private static Logger logger = Logger.getLogger(EntityTableLabelProvider.class);
	
	List<String> properties = new ArrayList<String>();
	
	public EntityTableLabelProvider(String... propertiesName)
	{
		if(propertiesName.length==0)
		{
			logger.warn("Aucune propriétés passées pour remplir le tableau");
			//FIXME: Prnedre la totalité des champs simples
		}
		else
		{
			for (int i = 0; i < propertiesName.length; i++) {
				String string = propertiesName[i];
				properties.add("get" + string.substring(1, 1).toUpperCase() + string.substring(2).toLowerCase());
			}
		}
	}
	
	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		T entity = (T)element;

		try {
			entity.getClass().getMethod(properties.get(columnIndex), null);
		} catch (SecurityException e) {
			logger.error(e);
		} catch (NoSuchMethodException e) {
			logger.error(e);
		}
		//FIXME: Monter les exceptions
		
		return "<ERROR>";
	}
	
}
