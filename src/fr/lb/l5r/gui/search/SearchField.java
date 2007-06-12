/**
 * 
 */
package fr.lb.l5r.gui.search;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Annotation accessible � l'execution
@Retention(RetentionPolicy.RUNTIME)

// Annotation associ� � un type (Classe, interface)
@Target(ElementType.METHOD)

/**
 * @author Administrateur
 *
 */
public @interface SearchField {	
}
