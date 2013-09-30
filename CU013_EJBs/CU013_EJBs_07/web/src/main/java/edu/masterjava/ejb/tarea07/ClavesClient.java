package edu.masterjava.ejb.tarea07;

import java.util.Hashtable;
import java.util.List;

import javax.ejb.EJBException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.masterjava.ejb.tarea07.bean.ClaveExRemote;
import edu.masterjava.ejb.tarea07.bean.impl.ClaveExImpl;
import edu.masterjava.ejb.tarea07.entity.Clave;

public class ClavesClient {
	
	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {

		new ClavesClient();
	}

	public ClavesClient() throws NamingException {
			final ClaveExRemote ejb = lookupRemoteEJB();

			List<Clave> claves = null;
			try {
				//ejb.create3Claves(1l, 2l, 3l);
				ejb.create3Claves(3l, 4l, 3l);
				claves = ejb.obtenerClaves();
				printClaves(claves);
			}
			catch(EJBException e) {
				//e.printStackTrace();
				claves = ejb.obtenerClaves();
				printClaves(claves);
			}
	}
	
	private void printClaves(List<Clave> claves) {
		for(Clave clave : claves) {
			System.out.println(clave.toString());
		}
	}
	
	private static ClaveExRemote lookupRemoteEJB() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        final Context context = new InitialContext(jndiProperties);
		
        final String appName = "cu013-tarea07-ear";
        final String moduleName = "cu013-tarea07-ejb";
        final String distinctName = "";
        final String beanName = ClaveExImpl.class.getSimpleName();

        final String viewClassName = ClaveExRemote.class.getName();
        System.out.println("Looking EJB via JNDI ");
        System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
        
        return (ClaveExRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
    }

}
