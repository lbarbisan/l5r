package fr.lb.l5r.gui.databindings;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.EditorPart;

import fr.lb.l5r.business.Configuration;
import fr.lb.l5r.business.entities.interfaces.IEntity;

public class DataBindingHelper {

	private static Logger logger = Logger.getLogger(DataBindingHelper.class);
	
	public static void bindPojoOnEditor(EditorPart editor, IEntity entity, DataBindingContext bindingContext)
	{
	  try {
		    
	        BeanInfo bi = Introspector.getBeanInfo(entity.getClass());
	        PropertyDescriptor[] pds = bi.getPropertyDescriptors();
	        
	        for (int i=0; i<pds.length; i++) {
	            // Get property name
	        	String property = pds[i].getName();
	        	Control control =  findControl(editor, property);
	        	if(control!=null)
	        	{
	        		initializeDataBinding(bindingContext, control, entity,  property);
	        	}
	        }
	    } catch (java.beans.IntrospectionException e) {
	    	logger.warn("IntrospectionException, Unable to find properties for bean: " + entity==null ? "null" : entity);
	    }
	}
	
	
	private static Control findControl(EditorPart editor,  String property)
	{
		try {
			logger.info("Try to find control for " + property==null? "null": property);
			Method method = editor.getClass().getDeclaredMethod("getTxt" + property.substring(0, 1).toUpperCase() + property.substring(1, property.length()), null);
			Object value = method.invoke(editor, null);
			if(value instanceof Control)
				return (Control)value;
			
		} catch (SecurityException e) {
			logger.warn("SecurityException, Unable to invoke method getTxt<...> for databinding ");
		} catch (IllegalArgumentException e) {
			logger.warn("IllegalArgumentException, Unable to invoke method getTxt<...> for databinding ");
		} catch (IllegalAccessException e) {
			logger.warn("IllegalAccessException, Unable to invoke method getTxt<...> for databinding ");
		} catch (InvocationTargetException e) {
			logger.warn("InvocationTargetException, Unable to invoke method getTxt<...> for databinding ");
		} catch (NoSuchMethodException e) {
			logger.warn("NoSuchMethodException, Unable to invoke method getTxt<...> for databinding ");
		}
		return null;
	}
	
	private static void initializeDataBinding(DataBindingContext bindingContext, Control control, IEntity entity, String property)
	{
//		IValidator nameLengthValidator = new IValidator() {
//			public IStatus validate(Object value) {
//				String name = (String) value;
//				if (name.length() > 30) {
//					return new Status(IStatus.ERROR, "",  // No plugin ID since we're a snippet
//							IStatus.OK,	"The name cannot be longer than 30 characters",
//							null);
//				} else {
//					return Status.OK_STATUS;
//				}
//			}
//		};	
		
		bindingContext.bindValue(
				SWTObservables.observeText(control, SWT.Modify),
				BeansObservables.observeValue(entity, property), 
				null,
				null); //new BindSpec().setTargetValidator(nameLengthValidator));
	}
}
