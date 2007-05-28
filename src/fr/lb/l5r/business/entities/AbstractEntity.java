package fr.lb.l5r.business.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import fr.lb.l5r.business.entities.interfaces.IEntity;

/**
 * @author Administrateur
 * 
 */
public abstract class AbstractEntity implements IEntity {

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	/**
	 * @param listener
	 */
	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * @param propertyName
	 * @param listener
	 */
	public void addPropertyChangeListener(final String propertyName, final PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	/**
	 * @param listener
	 */
	public void removePropertyChangeListener(final PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	/**
	 * @param propertyName
	 * @param listener
	 */
	public void removePropertyChangeListener(final String propertyName, final PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
	}

	protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	protected void firePropertyChange(String propertyName, int oldValue, int newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	protected void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}
}