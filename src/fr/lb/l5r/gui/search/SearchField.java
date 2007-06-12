/**
 * 
 */
package fr.lb.l5r.gui.search;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Annotation accessible à l'execution
@Retention(RetentionPolicy.RUNTIME)

// Annotation associé à un type (Classe, interface)
@Target(ElementType.METHOD)

/**
 * @author Administrateur
 *
 */
public @interface SearchField {	
}
