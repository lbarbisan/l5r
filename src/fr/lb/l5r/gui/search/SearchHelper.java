/**
 * 
 */
package fr.lb.l5r.gui.search;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Text;

/**
 * Cette classe retrouve les annotations d'une class de type editor
 * @author Laurent Barbisan
 *
 */
public class SearchHelper {
	
	private static Logger logger = Logger.getLogger(SearchHelper.class);

	/**
	 * permet de retrouver les annotations de type @SearchField
	 * @return une map de type nom de champ, valeur
	 */
	public static Map<String, Object> retrieveSearchField(Object editorPart)
	{
		Method[] methods = editorPart.getClass().getMethods();
		Map<String, Object> fields = new HashMap<String, Object>();
		
		try {
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				SearchField annotation = method.getAnnotation(SearchField.class);
				if(annotation!=null)
				{
					Text text = (Text) method.invoke(editorPart, null);	
					fields.put(getFieldNameForMethod(method), text.getText());
				}
			}
		
		} catch (IllegalArgumentException e) {
			logger.error(e);
		} catch (IllegalAccessException e) {
			logger.error(e);
		} catch (InvocationTargetException e) {
			logger.error(e);
		}
			
		return fields;
	}
	
	/**
	 * Supprimer les prefixes de la méthode passée en paramètre
	 * ex: getTxtName, renvoi name.
	 * @param method objet method
	 * @return renvoie le nom du champs associé à la méthode
	 */
	private static String getFieldNameForMethod(Method method)
	{
		String name = method.getName();
		return name.substring(6).toLowerCase(); 
	}
}
