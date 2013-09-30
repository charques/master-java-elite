package edu.masterjava.ejb.tarea01;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RemoteEjbClient {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		testRemoteEJB();
	}
	
	private static void testRemoteEJB() throws NamingException {

        final StringsBeanRemote ejb = lookupRemoteEJB();
        String s = ejb.convertirMayusculas("EJBs Tarea01 - Prueba Cliente Remoto");
        System.out.println(s);
    }
	
	private static StringsBeanRemote lookupRemoteEJB() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        final Context context = new InitialContext(jndiProperties);
		
        final String appName = "cu013-tarea01-ear";
        final String moduleName = "cu013-tarea01-ejb";
        final String distinctName = "";
        final String beanName = StringsBean.class.getSimpleName();

        final String viewClassName = StringsBeanRemote.class.getName();
        System.out.println("Looking EJB via JNDI ");
        System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
        
        return (StringsBeanRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
    }

}
