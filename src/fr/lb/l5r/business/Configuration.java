/**
 * 
 */
package fr.lb.l5r.business;

import java.io.File;
import java.util.Hashtable;

import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.jboss.ejb3.embedded.EJB3StandaloneBootstrap;
import org.jboss.ejb3.embedded.EJB3StandaloneDeployer;

import fr.lb.l5r.business.beans.EntityBean;

/**
 * @author Administrateur
 *
 */
public class Configuration {
	
	private final static Configuration instance = new Configuration();
	static
	{
		instance.initialize();
	}
	private Configuration(){}
	
	private static Logger logger = Logger.getLogger(Configuration.class);
	
	private InitialContext context;
	
	
	private void initialize()
	{
		EJB3StandaloneBootstrap.boot(null);
		try {
			EJB3StandaloneDeployer deployer = EJB3StandaloneBootstrap.createDeployer();
			File file = new File("G:\\Projects\\L5R\\L5RGui\\");
			
			deployer.getDeployDirs().add(file.toURL());
			deployer.create();
			deployer.start();
			
			context = getInitialContext();
		} catch (Exception e) {
			logger.error("Enable to initialize EJB3 Bootstrap", e);
			throw new RuntimeException(e);
		}
	}
	private static InitialContext getInitialContext() throws Exception {
		Hashtable props = getInitialContextProperties();
		return new InitialContext(props);
	}
	private static Hashtable getInitialContextProperties() {
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("java.naming.factory.initial",
				"org.jnp.interfaces.LocalOnlyContextFactory");
		props.put("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");
		return props;
	}

	
	/**
	 * 
	 * @return Instance de configuration
	 */
	public static Configuration getInstance()
	{
		return instance;
	}
	
	
	/**
	 * @return the context
	 */
	public InitialContext getContext() {
		return context;
	}
	/**
	 * @param context the context to set
	 */
	public void setContext(InitialContext context) {
		this.context = context;
	}
}
