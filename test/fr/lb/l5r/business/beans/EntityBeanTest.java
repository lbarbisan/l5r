/**
 * 
 */
package fr.lb.l5r.business.beans;

import java.io.File;
import java.net.URL;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.ejb3.embedded.EJB3StandaloneBootstrap;
import org.jboss.ejb3.embedded.EJB3StandaloneDeployer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.lb.l5r.business.beans.interfaces.IEntityLocal;
import fr.lb.l5r.business.entities.PersonnageJoueur;
import fr.lb.l5r.business.entities.interfaces.IEntity;

/**
 * @author Administrateur
 * 
 */
public class EntityBeanTest {

	private static InitialContext ctx;
	private static IEntityLocal local;
	private static int id;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
try {
			
			EJB3StandaloneBootstrap.boot(null);
			EJB3StandaloneBootstrap.scanClasspath();

			//EJB3StandaloneDeployer deployer = EJB3StandaloneBootstrap.createDeployer();
			//URL res = Thread.currentThread().getContextClassLoader().getResource("META-INF/persistence.xml");
			//URL path = EJB3StandaloneDeployer.getDeployDirFromResource(res, "META-INF/persistence.xml");
		    //deployer.getDeployDirs().add(res);	
			//deployer.create();
			//deployer.start();

			ctx = getInitialContext();
			local = (IEntityLocal) ctx.lookup("EntityBean/local");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link fr.lb.l5r.business.beans.EntityBean#create(java.lang.Class, java.lang.Object[])}.
	 * @throws NamingException 
	 */
	@Test
	public void testCreate() throws NamingException {
		id = local.create(PersonnageJoueur.class, "name", "Gavin");
	}

	/**
	 * Test method for
	 * {@link fr.lb.l5r.business.beans.EntityBean#find(java.lang.Class, int)}.
	 */
	@Test
	public void testFind() {
		IEntity cust = local.find(PersonnageJoueur.class, id);
	}
	
	
	public static InitialContext getInitialContext() throws Exception {
		Hashtable props = getInitialContextProperties();
		return new InitialContext(props);
	}

	private static Hashtable getInitialContextProperties() {
		Hashtable props = new Hashtable();
		props.put("java.naming.factory.initial","org.jnp.interfaces.LocalOnlyContextFactory");
		props.put("java.naming.factory.url.pkgs","org.jboss.naming:org.jnp.interfaces");
		return props;
	}

}
