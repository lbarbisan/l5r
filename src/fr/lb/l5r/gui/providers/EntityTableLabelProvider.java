/**
 * 
 */
package fr.lb.l5r.gui.providers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import fr.lb.l5r.business.entities.interfaces.IEntity;

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
				properties.add("get" + string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase());
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
			Method method =  entity.getClass().getMethod(properties.get(columnIndex), null);
			return (String) method.invoke(element, null);
		} catch (SecurityException e) {
			logger.error(e);
		} catch (NoSuchMethodException e) {
			logger.error(e);
		} catch (IllegalArgumentException e) {
			logger.error(e);
		} catch (IllegalAccessException e) {
			logger.error(e);
		} catch (InvocationTargetException e) {
			logger.error(e);
		}
		
		return "<ERROR>";
	}
	
}
