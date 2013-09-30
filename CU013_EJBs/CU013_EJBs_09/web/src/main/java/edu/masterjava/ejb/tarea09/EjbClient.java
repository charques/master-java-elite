package edu.masterjava.ejb.tarea09;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.masterjava.ejb.tarea09.bean.Ejb1Remote;
import edu.masterjava.ejb.tarea09.bean.impl.Ejb1Impl;

// -------------------------------------------------
// Resultados
// -------------------------------------------------
// CASO 1:
//    	- usuario: user1 - password: test - rol: rolBueno
//	  	- Se ejecuta correctamente. No lanza excepcion
// CASO 2:
//		- usuario: user2 - password: test - rol: rolMalo
//		- Invocation on method: public abstract void edu.masterjava.ejb.tarea09.bean.Ejb2Local.metodoInterno() of bean: Ejb2Impl is not allowed
// CASO 3:
//		- sin credenciales
//		- Invocation on method: public abstract void edu.masterjava.ejb.tarea09.bean.Ejb1Local.metodoExterno() of bean: Ejb1Impl is not allowed




public class EjbClient {
	
	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {

		new EjbClient();
	}

	public EjbClient() throws NamingException {
			final Ejb1Remote ejb = lookupRemoteEJB();
			ejb.metodoExterno();
	}

	
	private static Ejb1Remote lookupRemoteEJB() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        
        final Context context = new InitialContext(jndiProperties);
		
        final String appName = "cu013-tarea09-ear";
        final String moduleName = "cu013-tarea09-ejb";
        final String distinctName = "";
        final String beanName = Ejb1Impl.class.getSimpleName();

        final String viewClassName = Ejb1Remote.class.getName();
        System.out.println("Looking EJB via JNDI ");
        System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
        
        return (Ejb1Remote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
    }

}
